/*
 * Copyright (c) 2014-2025 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.WurstRenderLayerBridge;

public enum WurstRenderLayers
{
	;
	
	public static final RenderLayer.MultiPhase ONE_PIXEL_LINES =
		WurstRenderLayerBridge.ONE_PIXEL_LINES;
	
	public static final RenderLayer.MultiPhase ONE_PIXEL_LINE_STRIP =
		WurstRenderLayerBridge.ONE_PIXEL_LINE_STRIP;
	
	public static final RenderLayer.MultiPhase LINES =
		WurstRenderLayerBridge.LINES;
	
	public static final RenderLayer.MultiPhase ESP_LINES =
		WurstRenderLayerBridge.ESP_LINES;
	
	public static final RenderLayer.MultiPhase LINE_STRIP =
		WurstRenderLayerBridge.LINE_STRIP;
	
	public static final RenderLayer.MultiPhase ESP_LINE_STRIP =
		WurstRenderLayerBridge.ESP_LINE_STRIP;
	
	public static final RenderLayer.MultiPhase QUADS =
		WurstRenderLayerBridge.QUADS;
	
	public static final RenderLayer.MultiPhase ESP_QUADS =
		WurstRenderLayerBridge.ESP_QUADS;
	
	public static final RenderLayer.MultiPhase ESP_QUADS_NO_CULLING =
		WurstRenderLayerBridge.ESP_QUADS_NO_CULLING;
	
	public static RenderLayer getQuads(boolean depthTest)
	{
		return depthTest ? QUADS : ESP_QUADS;
	}
	
	public static RenderLayer getLines(boolean depthTest)
	{
		return depthTest ? LINES : ESP_LINES;
	}
	
	public static RenderLayer getLineStrip(boolean depthTest)
	{
		return depthTest ? LINE_STRIP : ESP_LINE_STRIP;
	}
}
