package free.cam.mod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class KeyPress {
private KeyBinding switc = new KeyBinding("Enable / Disable", Keyboard.KEY_U, "FreeCam");
private KeyBinding reset = new KeyBinding("Reset", Keyboard.KEY_O, "FreeCam");
private KeyBinding yt = new KeyBinding("Up", Keyboard.KEY_SPACE, "FreeCam");
private KeyBinding yt2 = new KeyBinding("Down", Keyboard.KEY_RSHIFT, "FreeCam");
private KeyBinding zt = new KeyBinding("Right", Keyboard.KEY_RIGHT, "FreeCam");
private KeyBinding zt2 = new KeyBinding("Left", Keyboard.KEY_LEFT, "FreeCam");
private KeyBinding xt = new KeyBinding("Forward", Keyboard.KEY_UP, "FreeCam");
private KeyBinding xt2 = new KeyBinding("Backward", Keyboard.KEY_DOWN, "FreeCam");

public KeyPress() {
	ClientRegistry.registerKeyBinding(switc);
	ClientRegistry.registerKeyBinding(yt);
	ClientRegistry.registerKeyBinding(yt2);
	ClientRegistry.registerKeyBinding(zt);
	ClientRegistry.registerKeyBinding(zt2);
	ClientRegistry.registerKeyBinding(xt);
	ClientRegistry.registerKeyBinding(xt2);
	ClientRegistry.registerKeyBinding(reset);
}

@SubscribeEvent
public void KeyInputEvent(KeyInputEvent event) {
	if(Main.timeout == 0 && GameSettings.isKeyDown(switc)) {
		Main.timeout = 10;
	    if(RenderEvent.enabled)RenderEvent.enabled=false; else RenderEvent.enabled=true;
	    if(RenderEvent.enabled) {
	    	RenderEvent.x = (int) Minecraft.getMinecraft().thePlayer.posX;
	    	RenderEvent.y = (int) Minecraft.getMinecraft().thePlayer.posY;
	    	RenderEvent.z = (int) Minecraft.getMinecraft().thePlayer.posZ;
	    	}
	}
	if(Main.timeout == 0 && GameSettings.isKeyDown(reset) && RenderEvent.enabled) {
		Main.timeout = 10;
	    	RenderEvent.x = (int) Minecraft.getMinecraft().thePlayer.posX;
	    	RenderEvent.y = (int) Minecraft.getMinecraft().thePlayer.posY;
	    	RenderEvent.z = (int) Minecraft.getMinecraft().thePlayer.posZ;
	}
	if(Main.timeout == 0 && GameSettings.isKeyDown(yt) && RenderEvent.enabled) {
		Main.timeout = 2;
	    	RenderEvent.y++;
	}
	if(Main.timeout == 0 && GameSettings.isKeyDown(yt2) && RenderEvent.enabled) {
		Main.timeout = 2;
	    	RenderEvent.y--;
	}
	if(Main.timeout == 0 && GameSettings.isKeyDown(zt) && RenderEvent.enabled) {
		Main.timeout = 2;
	    	RenderEvent.z++;
	}
	if(Main.timeout == 0 && GameSettings.isKeyDown(zt2) && RenderEvent.enabled) {
		Main.timeout = 2;
	    	RenderEvent.z--;
	}
	if(Main.timeout == 0 && GameSettings.isKeyDown(xt) && RenderEvent.enabled) {
		Main.timeout = 2;
	    	RenderEvent.x++;
	}
	if(Main.timeout == 0 && GameSettings.isKeyDown(xt2) && RenderEvent.enabled) {
		Main.timeout = 2;
	    	RenderEvent.x--;
	}
}
}