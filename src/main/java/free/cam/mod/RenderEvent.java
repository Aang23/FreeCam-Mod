package free.cam.mod;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderEvent {
	FakeClientPlayer fakePlayer = null;
	static int x,y,z;
	static int prevx,prevy,prevz;
	float prevyaw,prevpitch;
	static boolean enabled = false;
	@SubscribeEvent
	public void onPreRenderGame(RenderGameOverlayEvent.Pre event) {
		if(enabled) {
			if (fakePlayer == null) {
				fakePlayer = new FakeClientPlayer(Minecraft.getMinecraft().thePlayer.worldObj);
			}
			
			// set position and angles; note that posY is not altered but camera still correct:
			fakePlayer.setLocationAndAngles(x, y, z, Minecraft.getMinecraft().thePlayer.rotationYaw, Minecraft.getMinecraft().thePlayer.rotationPitch);

			// set previous values to prevent camera from freaking out:
			fakePlayer.prevRotationPitch = prevpitch;
			fakePlayer.prevRotationYaw = prevyaw;
			fakePlayer.rotationYawHead = Minecraft.getMinecraft().thePlayer.rotationYawHead;
			fakePlayer.prevPosX = prevx;
			fakePlayer.prevPosY = prevy;
			fakePlayer.prevPosZ = prevz;
			Minecraft.getMinecraft().setRenderViewEntity(fakePlayer);
			
			prevx = x;
			prevy = y;
			prevz = z;
			prevpitch = Minecraft.getMinecraft().thePlayer.rotationPitch;
			prevyaw = Minecraft.getMinecraft().thePlayer.rotationYaw;
	}
		else {
			Minecraft.getMinecraft().setRenderViewEntity(Minecraft.getMinecraft().thePlayer);
		}
	}
}




