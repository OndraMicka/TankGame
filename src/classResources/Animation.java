package classResources;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Made by Gemini AI <p>
 *
 * This class handles animations from sprite sheets.
 * It cuts up one image into frames and plays them.
 */
public class Animation {

    private final List<BufferedImage> frames;
    private final double frameDuration;
    private double elapsedTime = 0;
    private int currentFrameIndex = 0;
    private boolean looping = true;
    private boolean playing = true;

    /**
     * Map for actions (like sounds) to run on certain frames.
     */
    private final Map<Integer, Runnable> frameTriggers = new HashMap<>();

    /**
     * Keeps track of the last frame that triggered something, so it doesn't repeat.
     * At start, it holds -1 to indicate no frame has triggered yet.
     */
    private int lastTriggeredFrame = -1;

    /**
     * Makes a new animation by slicing a sprite sheet.
     * @param spriteSheet   The big image with all frames.
     * @param rows          How many rows to split into.
     * @param cols          How many columns to split into.
     * @param totalFrames   How many frames to make, size of array.
     * @param frameDuration How long each frame shows (in seconds).
     */
    public Animation(BufferedImage spriteSheet, int rows, int cols, int totalFrames, double frameDuration) {
        this.frameDuration = frameDuration;
        this.frames = new ArrayList<>();

        int width = spriteSheet.getWidth() / cols;
        int height = spriteSheet.getHeight() / rows;

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (count < totalFrames) {
                    frames.add(spriteSheet.getSubimage(j * width, i * height, width, height));
                    count++;
                }
            }
        }
    }


    /**
     * Registers a custom action to be executed when the animation reaches a specific frame.
     * @param frameIndex The index of the frame (0 to totalFrames - 1).
     * @param action     The Runnable containing the code to execute (e.g. play a sound).
     */
    public void addTrigger(int frameIndex, Runnable action) {
        frameTriggers.put(frameIndex, action);
        //TODO: add engine sound for game and sound effects
    }

    /**
     * Updates the animation state based on the elapsed time.
     * Call this method in game loop.
     * @param deltaTime The time passed since the last update in seconds (e.g., 0.016 for 60 FPS).
     */
    public void update(double deltaTime) {
        if (!playing) return;

        elapsedTime += deltaTime;

        if (elapsedTime >= frameDuration) {
            elapsedTime = 0;
            currentFrameIndex++;

            if (currentFrameIndex >= frames.size()) {
                if (looping) {
                    currentFrameIndex = 0;
                    lastTriggeredFrame = -1;
                } else {
                    currentFrameIndex = frames.size() - 1;
                    playing = false;
                }
            }
            checkTriggers();
        }
    }

    /**
     * Checks if any triggers should run on the current frame.
     */
    private void checkTriggers() {
        if (frameTriggers.containsKey(currentFrameIndex) && lastTriggeredFrame != currentFrameIndex) {
            frameTriggers.get(currentFrameIndex).run();
            lastTriggeredFrame = currentFrameIndex;
        }
    }

    /**
     * Returns the current image frame to be rendered.
     * @return The BufferedImage of the current frame.
     */
    public BufferedImage getCurrentFrame() {
        return frames.get(currentFrameIndex);
    }

    /**
     * Resets the animation to the first frame and starts playback.
     */
    public void reset() {
        this.elapsedTime = 0;
        this.currentFrameIndex = 0;
        this.playing = true;
        this.lastTriggeredFrame = -1;
    }

    /**
     * Pauses the animation playback.
     */
    public void stop() {
        this.playing = false;
    }

    /**
     * Resumes the animation playback.
     */
    public void play() {
        this.playing = true;
    }

    /**
     * Checks if the animation has reached its final frame (only for non-looping animations).
     * @return true if the animation is finished.
     */
    public boolean isFinished() {
        return !looping && currentFrameIndex == frames.size() - 1 && !playing;
    }

    /**
     * Enables or disables looping.
     * @param looping true to repeat, false to play once.
     */
    public void setLooping(boolean looping) {
        this.looping = looping;
    }

    /**
     * Gets the total number of frames in this animation.
     * @return count of frames.
     */
    public int getTotalFrames() {
        return frames.size();
    }

    /**
     * Returns the playback progress.
     * @return A value between 0.0 (start) and 1.0 (end).
     */
    public double getProgress() {
        if (frames.isEmpty()) return 0;
        return (double) currentFrameIndex / (frames.size() - 1);
    }
}