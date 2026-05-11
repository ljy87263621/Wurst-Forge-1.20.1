/*
 * Copyright (c) 2014-2025 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.minecraft.client.render;

import java.util.OptionalDouble;

import net.minecraft.client.render.VertexFormat.DrawMode;
import net.wurstclient.mixin.RenderLayerInvoker;
import net.wurstclient.mixin.RenderPhaseAccessor;

public enum WurstRenderLayerBridge
{
	;
	
	public static final RenderLayer.MultiPhase ONE_PIXEL_LINES =
		RenderLayerInvoker.wurstCreate("wurst:1px_lines",
			VertexFormats.POSITION_COLOR, DrawMode.DEBUG_LINES, 1536, false,
			true,
			RenderLayer.MultiPhaseParameters.builder()
				.program(RenderPhaseAccessor.getColorProgram())
				.lineWidth(new RenderPhase.LineWidth(OptionalDouble.of(1)))
				.transparency(RenderPhaseAccessor.getTranslucentTransparency())
				.cull(RenderPhaseAccessor.getDisableCulling()).build(false));
	
	public static final RenderLayer.MultiPhase ONE_PIXEL_LINE_STRIP =
		RenderLayerInvoker.wurstCreate("wurst:1px_line_strip",
			VertexFormats.POSITION_COLOR, DrawMode.DEBUG_LINE_STRIP, 1536,
			false, true,
			RenderLayer.MultiPhaseParameters.builder()
				.program(RenderPhaseAccessor.getColorProgram())
				.lineWidth(new RenderPhase.LineWidth(OptionalDouble.of(1)))
				.transparency(RenderPhaseAccessor.getTranslucentTransparency())
				.cull(RenderPhaseAccessor.getDisableCulling()).build(false));
	
	public static final RenderLayer.MultiPhase LINES =
		RenderLayerInvoker.wurstCreate("wurst:lines", VertexFormats.LINES,
			VertexFormat.DrawMode.LINES, 1536, false, true,
			RenderLayer.MultiPhaseParameters.builder()
				.program(RenderPhaseAccessor.getLinesProgram())
				.lineWidth(new RenderPhase.LineWidth(OptionalDouble.of(2)))
				.layering(RenderPhaseAccessor.getViewOffsetZLayering())
				.transparency(RenderPhaseAccessor.getTranslucentTransparency())
				.target(RenderPhaseAccessor.getItemEntityTarget())
				.writeMaskState(RenderPhaseAccessor.getAllMask())
				.depthTest(RenderPhaseAccessor.getLequalDepthTest())
				.cull(RenderPhaseAccessor.getDisableCulling()).build(false));
	
	public static final RenderLayer.MultiPhase ESP_LINES =
		RenderLayerInvoker.wurstCreate("wurst:esp_lines", VertexFormats.LINES,
			VertexFormat.DrawMode.LINES, 1536, false, true,
			RenderLayer.MultiPhaseParameters.builder()
				.program(RenderPhaseAccessor.getLinesProgram())
				.lineWidth(new RenderPhase.LineWidth(OptionalDouble.of(2)))
				.layering(RenderPhaseAccessor.getViewOffsetZLayering())
				.transparency(RenderPhaseAccessor.getTranslucentTransparency())
				.target(RenderPhaseAccessor.getItemEntityTarget())
				.writeMaskState(RenderPhaseAccessor.getAllMask())
				.depthTest(RenderPhaseAccessor.getAlwaysDepthTest())
				.cull(RenderPhaseAccessor.getDisableCulling()).build(false));
	
	public static final RenderLayer.MultiPhase LINE_STRIP =
		RenderLayerInvoker.wurstCreate("wurst:line_strip", VertexFormats.LINES,
			VertexFormat.DrawMode.LINE_STRIP, 1536, false, true,
			RenderLayer.MultiPhaseParameters.builder()
				.program(RenderPhaseAccessor.getLinesProgram())
				.lineWidth(new RenderPhase.LineWidth(OptionalDouble.of(2)))
				.layering(RenderPhaseAccessor.getViewOffsetZLayering())
				.transparency(RenderPhaseAccessor.getTranslucentTransparency())
				.target(RenderPhaseAccessor.getItemEntityTarget())
				.writeMaskState(RenderPhaseAccessor.getAllMask())
				.depthTest(RenderPhaseAccessor.getLequalDepthTest())
				.cull(RenderPhaseAccessor.getDisableCulling()).build(false));
	
	public static final RenderLayer.MultiPhase ESP_LINE_STRIP =
		RenderLayerInvoker.wurstCreate("wurst:esp_line_strip",
			VertexFormats.LINES, VertexFormat.DrawMode.LINE_STRIP, 1536, false,
			true,
			RenderLayer.MultiPhaseParameters.builder()
				.program(RenderPhaseAccessor.getLinesProgram())
				.lineWidth(new RenderPhase.LineWidth(OptionalDouble.of(2)))
				.layering(RenderPhaseAccessor.getViewOffsetZLayering())
				.transparency(RenderPhaseAccessor.getTranslucentTransparency())
				.target(RenderPhaseAccessor.getItemEntityTarget())
				.writeMaskState(RenderPhaseAccessor.getAllMask())
				.depthTest(RenderPhaseAccessor.getAlwaysDepthTest())
				.cull(RenderPhaseAccessor.getDisableCulling()).build(false));
	
	public static final RenderLayer.MultiPhase QUADS = RenderLayerInvoker
		.wurstCreate("wurst:quads", VertexFormats.POSITION_COLOR,
			VertexFormat.DrawMode.QUADS, 1536, false, true,
			RenderLayer.MultiPhaseParameters.builder()
				.program(RenderPhaseAccessor.getColorProgram())
				.transparency(RenderPhaseAccessor.getTranslucentTransparency())
				.depthTest(RenderPhaseAccessor.getLequalDepthTest())
				.build(false));
	
	public static final RenderLayer.MultiPhase ESP_QUADS = RenderLayerInvoker
		.wurstCreate("wurst:esp_quads", VertexFormats.POSITION_COLOR,
			VertexFormat.DrawMode.QUADS, 1536, false, true,
			RenderLayer.MultiPhaseParameters.builder()
				.program(RenderPhaseAccessor.getColorProgram())
				.transparency(RenderPhaseAccessor.getTranslucentTransparency())
				.depthTest(RenderPhaseAccessor.getAlwaysDepthTest())
				.build(false));
	
	public static final RenderLayer.MultiPhase ESP_QUADS_NO_CULLING =
		RenderLayerInvoker.wurstCreate("wurst:esp_quads_no_culling",
			VertexFormats.POSITION_COLOR, VertexFormat.DrawMode.QUADS, 1536,
			false, true,
			RenderLayer.MultiPhaseParameters.builder()
				.program(RenderPhaseAccessor.getColorProgram())
				.transparency(RenderPhaseAccessor.getTranslucentTransparency())
				.cull(RenderPhaseAccessor.getDisableCulling())
				.depthTest(RenderPhaseAccessor.getAlwaysDepthTest())
				.build(false));
}
