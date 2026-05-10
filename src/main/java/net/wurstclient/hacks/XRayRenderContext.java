/*
 * Copyright (c) 2014-2025 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.hacks;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.wurstclient.WurstClient;

public final class XRayRenderContext
{
	private static final ThreadLocal<BlockState> CURRENT_STATE =
		new ThreadLocal<>();
	private static final ThreadLocal<BlockPos> CURRENT_POS =
		new ThreadLocal<>();
	
	private XRayRenderContext()
	{}
	
	public static void setBlock(BlockState state, BlockPos pos)
	{
		CURRENT_STATE.set(state);
		CURRENT_POS.set(pos);
	}
	
	public static void clearBlock()
	{
		CURRENT_STATE.remove();
		CURRENT_POS.remove();
	}
	
	public static float getAlpha(float originalAlpha)
	{
		BlockState state = CURRENT_STATE.get();
		BlockPos pos = CURRENT_POS.get();
		if(state == null || pos == null)
			return originalAlpha;
		
		XRayHack xray = WurstClient.INSTANCE.getHax().xRayHack;
		if(!xray.isOpacityMode() || xray.isVisible(state.getBlock(), pos))
			return originalAlpha;
		
		int alpha = xray.getOpacityColorMask() >>> 24 & 0xFF;
		return originalAlpha * alpha / 255F;
	}
}
