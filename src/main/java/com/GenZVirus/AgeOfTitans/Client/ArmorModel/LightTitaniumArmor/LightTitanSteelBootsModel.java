package com.GenZVirus.AgeOfTitans.Client.ArmorModel.LightTitaniumArmor;

import com.GenZVirus.AgeOfTitans.Client.ArmorModel.ArmorModelBase;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.inventory.EquipmentSlotType;

public class LightTitanSteelBootsModel extends ArmorModelBase {

	public float leftOffsetX = 2.1F;
	public float leftOffsetY = 0;
	public float leftOffsetZ = 0;
	public float rightOffsetX = -1.3F;
	public float rightOffsetY = 0;
	public float rightOffsetZ = 0;
	
	public LightTitanSteelBootsModel() {
		super(EquipmentSlotType.FEET);
		textureWidth = 64;
		textureHeight = 64;

		bipedLeftLeg = new ModelRenderer(this);
		bipedLeftLeg.setRotationPoint(4.2F, 24.0F, -1.0F);
		bipedLeftLeg.setTextureOffset(10, 21).addBox(-4.3F + leftOffsetX, 7.1F + leftOffsetY, -2.1F + leftOffsetZ, 4.0F, 5.0F, 1.0F, 0.0F, false);
		bipedLeftLeg.setTextureOffset(12, 12).addBox(-1.1F + leftOffsetX, 7.1F + leftOffsetY, -2.1F + leftOffsetZ, 1.0F, 5.0F, 4.0F, 0.0F, false);
		bipedLeftLeg.setTextureOffset(0, 20).addBox(-4.1F + leftOffsetX, 7.1F + leftOffsetY, 1.1F + leftOffsetZ, 4.0F, 5.0F, 1.0F, 0.0F, false);
		bipedLeftLeg.setTextureOffset(0, 11).addBox(-4.3F + leftOffsetX, 7.1F + leftOffsetY, -1.9F + leftOffsetZ, 1.0F, 5.0F, 4.0F, 0.0F, false);
		bipedLeftLeg.setTextureOffset(18, 0).addBox(-3.7F + leftOffsetX, 11.2F + leftOffsetY, -1.5F + leftOffsetZ, 3.0F, 1.0F, 3.0F, 0.0F, false);
		bipedLeftLeg.setTextureOffset(18, 27).addBox(-3.1F + leftOffsetX, 8.0F + leftOffsetY, -2.3F + leftOffsetZ, 2.0F, 4.0F, 1.0F, 0.0F, false);
		bipedLeftLeg.setTextureOffset(24, 16).addBox(-3.1F + leftOffsetX, 7.0F + leftOffsetY, 1.2F + leftOffsetZ, 2.0F, 5.0F, 1.0F, 0.0F, false);
		bipedLeftLeg.setTextureOffset(6, 26).addBox(-1.0F + leftOffsetX, 7.0F + leftOffsetY, -1.0F + leftOffsetZ, 1.0F, 5.0F, 2.0F, 0.0F, false);
		bipedLeftLeg.setTextureOffset(0, 26).addBox(-4.4F + leftOffsetX, 7.0F + leftOffsetY, -1.0F + leftOffsetZ, 1.0F, 5.0F, 2.0F, 0.0F, false);

		bipedRightLeg = new ModelRenderer(this);
		bipedRightLeg.setRotationPoint(-3.2F, 24.0F, -1.0F);
		bipedRightLeg.setTextureOffset(18, 10).addBox(-0.9F + rightOffsetX, 7.1F + rightOffsetY, -2.1F + rightOffsetZ, 4.0F, 5.0F, 1.0F, 0.0F, false);
		bipedRightLeg.setTextureOffset(6, 6).addBox(2.3F + rightOffsetX, 7.1F + rightOffsetY, -2.1F + rightOffsetZ, 1.0F, 5.0F, 4.0F, 0.0F, false);
		bipedRightLeg.setTextureOffset(12, 4).addBox(-0.7F + rightOffsetX, 7.1F + rightOffsetY, 1.1F + rightOffsetZ, 4.0F, 5.0F, 1.0F, 0.0F, false);
		bipedRightLeg.setTextureOffset(0, 0).addBox(-0.9F + rightOffsetX, 7.1F + rightOffsetY, -1.9F + rightOffsetZ, 1.0F, 5.0F, 4.0F, 0.0F, false);
		bipedRightLeg.setTextureOffset(6, 0).addBox(-0.3F + rightOffsetX, 11.2F + rightOffsetY, -1.5F + rightOffsetZ, 3.0F, 1.0F, 3.0F, 0.0F, false);
		bipedRightLeg.setTextureOffset(12, 27).addBox(0.1F + rightOffsetX, 8.0F + rightOffsetY, -2.3F + rightOffsetZ, 2.0F, 4.0F, 1.0F, 0.0F, false);
		bipedRightLeg.setTextureOffset(22, 4).addBox(0.1F + rightOffsetX, 7.0F + rightOffsetY, 1.2F + rightOffsetZ, 2.0F, 5.0F, 1.0F, 0.0F, false);
		bipedRightLeg.setTextureOffset(24, 25).addBox(2.4F + rightOffsetX, 7.0F + rightOffsetY, -1.0F + rightOffsetZ, 1.0F, 5.0F, 2.0F, 0.0F, false);
		bipedRightLeg.setTextureOffset(20, 20).addBox(-1.0F + rightOffsetX, 7.0F + rightOffsetY, -1.0F + rightOffsetZ, 1.0F, 5.0F, 2.0F, 0.0F, false);
	
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bipedLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		bipedRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);

	}
}