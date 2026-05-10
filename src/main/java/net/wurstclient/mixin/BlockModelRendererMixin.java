/*
 * Copyright (c) 2014-2025 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.block.BlockState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;
import net.wurstclient.hacks.XRayRenderContext;

@Mixin(BlockModelRenderer.class)
public class BlockModelRendererMixin
{
	@Inject(at = @At("HEAD"),
		method = "renderQuad(Lnet/minecraft/world/BlockRenderView;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/client/render/VertexConsumer;Lnet/minecraft/client/util/math/MatrixStack$Entry;Lnet/minecraft/client/render/model/BakedQuad;FFFFIIIII)V")
	private void onRenderQuad(BlockRenderView world, BlockState state,
		BlockPos pos, VertexConsumer vertexConsumer, MatrixStack.Entry entry,
		BakedQuad quad, float brightness0, float brightness1, float brightness2,
		float brightness3, int light0, int light1, int light2, int light3,
		int overlay, CallbackInfo ci)
	{
		XRayRenderContext.setBlock(state, pos);
	}
	
	@Redirect(at = @At(value = "INVOKE",
		target = "Lnet/minecraft/client/render/VertexConsumer;quad(Lnet/minecraft/client/util/math/MatrixStack$Entry;Lnet/minecraft/client/render/model/BakedQuad;[FFFF[IIZ)V"),
		method = "renderQuad(Lnet/minecraft/world/BlockRenderView;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/client/render/VertexConsumer;Lnet/minecraft/client/util/math/MatrixStack$Entry;Lnet/minecraft/client/render/model/BakedQuad;FFFFIIIII)V")
	private void onQuad(VertexConsumer vertexConsumer, MatrixStack.Entry entry,
		BakedQuad quad, float[] brightnesses, float red, float green,
		float blue, int[] lights, int overlay, boolean useQuadColorData)
	{
		float alpha = XRayRenderContext.getAlpha(1);
		vertexConsumer.putBulkData(entry, quad, brightnesses, red, green, blue,
			alpha, lights, overlay, useQuadColorData);
	}
	
	@Inject(at = @At("RETURN"),
		method = "renderQuad(Lnet/minecraft/world/BlockRenderView;Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/client/render/VertexConsumer;Lnet/minecraft/client/util/math/MatrixStack$Entry;Lnet/minecraft/client/render/model/BakedQuad;FFFFIIIII)V")
	private void afterRenderQuad(BlockRenderView world, BlockState state,
		BlockPos pos, VertexConsumer vertexConsumer, MatrixStack.Entry entry,
		BakedQuad quad, float brightness0, float brightness1, float brightness2,
		float brightness3, int light0, int light1, int light2, int light3,
		int overlay, CallbackInfo ci)
	{
		XRayRenderContext.clearBlock();
	}
}
