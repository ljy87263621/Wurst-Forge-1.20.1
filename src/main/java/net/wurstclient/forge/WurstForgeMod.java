/*
 * Copyright (c) 2014-2025 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.forge;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.common.MinecraftForge;
import net.wurstclient.WurstClient;

@Mod("wurst")
public final class WurstForgeMod
{
	public WurstForgeMod()
	{
		if(FMLEnvironment.dist != Dist.CLIENT)
			return;
		
		IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
		modBus.addListener(this::onClientSetup);
		
		IEventBus forgeBus = MinecraftForge.EVENT_BUS;
		forgeBus.addListener(this::onClientLogin);
	}
	
	private void onClientSetup(FMLClientSetupEvent event)
	{
		event.enqueueWork(this::initializeWurst);
	}
	
	private void initializeWurst()
	{
		WurstClient.INSTANCE.initialize();
	}
	
	private void onClientLogin(ClientPlayerNetworkEvent.LoggingIn event)
	{
		if(!WurstClient.INSTANCE.isInitialized())
			return;
		
		WurstClient.INSTANCE.getOtfs().noChatReportsOtf.onLoginStart();
	}
	
	public static boolean isLoaded(String modId)
	{
		return ModList.get().isLoaded(modId);
	}
	
	public static boolean isDevelopmentEnvironment()
	{
		return !FMLLoader.isProduction();
	}
	
	public static String getVersion(String modId)
	{
		return ModList.get().getModContainerById(modId)
			.map(container -> container.getModInfo().getVersion().toString())
			.orElse(null);
	}
	
	public static java.nio.file.Path getGameDir()
	{
		return FMLPaths.GAMEDIR.get();
	}
}
