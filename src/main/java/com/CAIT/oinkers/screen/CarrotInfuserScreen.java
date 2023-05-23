package com.CAIT.oinkers.screen;

import com.CAIT.oinkers.oinkers;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CarrotInfuserScreen extends AbstractContainerScreen<CarrotInfuserMenu>{
	public static final ResourceLocation TEXTURE =
			new ResourceLocation(oinkers.MOD_ID, "textures/gui/carrot_infuser_gui.png");

	public CarrotInfuserScreen(CarrotInfuserMenu menu, Inventory inv, Component component) {
		super(menu, inv, component);
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		super.init();
	}

	@Override
	protected void renderBg(PoseStack stack, float pPartialTick, int pMouseX, int pMouseY) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(stack, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(stack, x, y);
		
	}
	
	private void renderProgressArrow(PoseStack pPoseStack, int x, int y) {
        if(menu.isCrafting()) {
            blit(pPoseStack, x + 105, y + 44, 177, 3, menu.getScaledProgress(), 26);
        }
    }
	
	@Override
	public void render(PoseStack stack, int mouseX, int mouseY, float delta) {
		renderBackground(stack);
		super.render(stack, mouseX, mouseY, delta);
		renderTooltip(stack, mouseX,mouseY);
	}

}
