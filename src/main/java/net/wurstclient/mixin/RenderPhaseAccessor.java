/*
 * Copyright (c) 2014-2025 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.client.render.RenderPhase;

@Mixin(RenderPhase.class)
public interface RenderPhaseAccessor
{
	@Accessor("COLOR_PROGRAM")
	static RenderPhase.ShaderProgram getColorProgram()
	{
		throw new AssertionError();
	}
	
	@Accessor("LINES_PROGRAM")
	static RenderPhase.ShaderProgram getLinesProgram()
	{
		throw new AssertionError();
	}
	
	@Accessor("TRANSLUCENT_TRANSPARENCY")
	static RenderPhase.Transparency getTranslucentTransparency()
	{
		throw new AssertionError();
	}
	
	@Accessor("DISABLE_CULLING")
	static RenderPhase.Cull getDisableCulling()
	{
		throw new AssertionError();
	}
	
	@Accessor("VIEW_OFFSET_Z_LAYERING")
	static RenderPhase.Layering getViewOffsetZLayering()
	{
		throw new AssertionError();
	}
	
	@Accessor("ITEM_ENTITY_TARGET")
	static RenderPhase.Target getItemEntityTarget()
	{
		throw new AssertionError();
	}
	
	@Accessor("ALL_MASK")
	static RenderPhase.WriteMaskState getAllMask()
	{
		throw new AssertionError();
	}
	
	@Accessor("LEQUAL_DEPTH_TEST")
	static RenderPhase.DepthTest getLequalDepthTest()
	{
		throw new AssertionError();
	}
	
	@Accessor("ALWAYS_DEPTH_TEST")
	static RenderPhase.DepthTest getAlwaysDepthTest()
	{
		throw new AssertionError();
	}
}
