package free.cam.mod;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class TickHandler {



@SubscribeEvent
public void Tick(ClientTickEvent event) {
	if(Main.timeout>0) Main.timeout--;
}
}