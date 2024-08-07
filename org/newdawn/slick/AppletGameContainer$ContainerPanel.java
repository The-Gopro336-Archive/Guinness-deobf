package org.newdawn.slick;

import org.newdawn.slick.util.Log;
import org.newdawn.slick.openal.SoundStore;
import org.newdawn.slick.opengl.InternalTextureLoader;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.PixelFormat;

public class ContainerPanel
{
    private Container container;
    
    public ContainerPanel(final Container container) {
        this.container = container;
    }
    
    private void createDisplay() throws Exception {
        try {
            Display.create(new PixelFormat(8, 8, GameContainer.stencil ? 8 : 0));
            AppletGameContainer.this.alphaSupport = true;
        }
        catch (Exception e) {
            AppletGameContainer.this.alphaSupport = false;
            Display.destroy();
            Display.create();
        }
    }
    
    public void start() throws Exception {
        Display.setParent(AppletGameContainer.this.displayParent);
        Display.setVSyncEnabled(true);
        try {
            this.createDisplay();
        }
        catch (LWJGLException e) {
            e.printStackTrace();
            Thread.sleep(1000L);
            this.createDisplay();
        }
        this.initGL();
        AppletGameContainer.this.displayParent.requestFocus();
        this.container.runloop();
    }
    
    protected void initGL() {
        try {
            InternalTextureLoader.get().clear();
            SoundStore.get().clear();
            this.container.initApplet();
        }
        catch (Exception e) {
            Log.error(e);
            this.container.stopApplet();
        }
    }
}
