package com.GenZVirus.AgeOfTitans.Client.ArmorModel.HeavyTitaniumArmor;

import com.GenZVirus.AgeOfTitans.Client.ArmorModel.ArmorModelBase;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.inventory.EquipmentSlotType;

public class HeavyTitanSteelChestplateModel extends ArmorModelBase {

	private float rightArmOffsetX = 1.0F;
	private float rightArmOffsetY = 0;
	private float rightArmOffsetZ = -2.0F;
	private float leftArmOffsetX = 3.5F;
	private float leftArmOffsetY = -4.0F;
	private float leftArmOffsetZ = -3.0F;
	private float armorOffsetX = 3.0F;
	private float armorOffsetY = 0;
	private float armorOffsetZ = 2.0F;
	private float OffsetX = 0;
	private float OffsetY = -0.3F;
	private float OffsetZ = 0;

	public HeavyTitanSteelChestplateModel() {
		super(EquipmentSlotType.CHEST);
		textureWidth = 128;
		textureHeight = 128;
		bipedBody = new ModelRenderer(this);
		bipedBody.setRotationPoint(3.0F, 22.8F, 1.8F);
		bipedBody.setTextureOffset(10, 47).addBox(-6.0F + OffsetX + armorOffsetX, 1.05F + OffsetY + armorOffsetY, -0.5F + OffsetZ + armorOffsetZ, 1.0F, 9.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(60, 22).addBox(-4.0F + OffsetX + armorOffsetX, 11.1F + OffsetY + armorOffsetY, -5.0F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(56, 68).addBox(-2.0F + OffsetX + armorOffsetX, 10.6F + OffsetY + armorOffsetY, -5.0F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(36, 68).addBox(-1.0F + OffsetX + armorOffsetX, 10.1F + OffsetY + armorOffsetY, -5.0F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(50, 68).addBox(-5.0F + OffsetX + armorOffsetX, 10.6F + OffsetY + armorOffsetY, -5.0F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(14, 68).addBox(-6.0F + OffsetX + armorOffsetX, 10.1F + OffsetY + armorOffsetY, -5.0F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(32, 60).addBox(-7.1F + OffsetX + armorOffsetX, 9.6F + OffsetY + armorOffsetY, -5.0F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(20, 60).addBox(-0.9F + OffsetX + armorOffsetX, 9.6F + OffsetY + armorOffsetY, -5.0F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(59, 47).addBox(-4.0F + OffsetX + armorOffsetX, 10.1F + OffsetY + armorOffsetY, -5.1F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(46, 67).addBox(-2.0F + OffsetX + armorOffsetX, 9.6F + OffsetY + armorOffsetY, -5.1F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(67, 24).addBox(-1.0F + OffsetX + armorOffsetX, 9.1F + OffsetY + armorOffsetY, -5.1F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(67, 38).addBox(-5.0F + OffsetX + armorOffsetX, 9.6F + OffsetY + armorOffsetY, -5.1F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(59, 50).addBox(-7.1F + OffsetX + armorOffsetX, 8.6F + OffsetY + armorOffsetY, -5.1F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(0, 68).addBox(-6.0F + OffsetX + armorOffsetX, 9.1F + OffsetY + armorOffsetY, -5.1F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(59, 54).addBox(-0.9F + OffsetX + armorOffsetX, 8.6F + OffsetY + armorOffsetY, -5.1F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(4, 67).addBox(-6.0F + OffsetX + armorOffsetX, 8.1F + OffsetY + armorOffsetY, -5.2F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(51, 59).addBox(-7.1F + OffsetX + armorOffsetX, 7.6F + OffsetY + armorOffsetY, -5.2F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(10, 67).addBox(-5.0F + OffsetX + armorOffsetX, 8.6F + OffsetY + armorOffsetY, -5.2F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(22, 67).addBox(-1.0F + OffsetX + armorOffsetX, 8.1F + OffsetY + armorOffsetY, -5.2F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(32, 67).addBox(-2.0F + OffsetX + armorOffsetX, 8.6F + OffsetY + armorOffsetY, -5.2F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(59, 59).addBox(-4.0F + OffsetX + armorOffsetX, 9.1F + OffsetY + armorOffsetY, -5.2F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(59, 11).addBox(-0.9F + OffsetX + armorOffsetX, 7.6F + OffsetY + armorOffsetY, -5.2F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(58, 8).addBox(-4.0F + OffsetX + armorOffsetX, 8.1F + OffsetY + armorOffsetY, -5.3F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(66, 3).addBox(-2.0F + OffsetX + armorOffsetX, 7.6F + OffsetY + armorOffsetY, -5.3F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(66, 6).addBox(-1.0F + OffsetX + armorOffsetX, 7.1F + OffsetY + armorOffsetY, -5.3F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(66, 21).addBox(-5.0F + OffsetX + armorOffsetX, 7.6F + OffsetY + armorOffsetY, -5.3F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(58, 44).addBox(-7.1F + OffsetX + armorOffsetX, 6.6F + OffsetY + armorOffsetY, -5.3F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(66, 61).addBox(-6.0F + OffsetX + armorOffsetX, 7.1F + OffsetY + armorOffsetY, -5.3F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(0, 59).addBox(-0.9F + OffsetX + armorOffsetX, 6.6F + OffsetY + armorOffsetY, -5.3F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(28, 66).addBox(-6.0F + OffsetX + armorOffsetX, 6.1F + OffsetY + armorOffsetY, -5.4F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(6, 58).addBox(-7.1F + OffsetX + armorOffsetX, 5.6F + OffsetY + armorOffsetY, -5.4F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(42, 66).addBox(-5.0F + OffsetX + armorOffsetX, 6.6F + OffsetY + armorOffsetY, -5.4F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(66, 66).addBox(-1.0F + OffsetX + armorOffsetX, 6.1F + OffsetY + armorOffsetY, -5.4F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(66, 0).addBox(-2.0F + OffsetX + armorOffsetX, 6.6F + OffsetY + armorOffsetY, -5.4F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(14, 58).addBox(-4.0F + OffsetX + armorOffsetX, 7.1F + OffsetY + armorOffsetY, -5.4F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(40, 58).addBox(-0.9F + OffsetX + armorOffsetX, 5.6F + OffsetY + armorOffsetY, -5.4F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(34, 57).addBox(-4.0F + OffsetX + armorOffsetX, 6.1F + OffsetY + armorOffsetY, -5.5F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(65, 52).addBox(-2.0F + OffsetX + armorOffsetX, 5.6F + OffsetY + armorOffsetY, -5.5F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(65, 55).addBox(-1.0F + OffsetX + armorOffsetX, 5.1F + OffsetY + armorOffsetY, -5.5F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(65, 58).addBox(-5.0F + OffsetX + armorOffsetX, 5.6F + OffsetY + armorOffsetY, -5.5F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(57, 26).addBox(-7.1F + OffsetX + armorOffsetX, 4.6F + OffsetY + armorOffsetY, -5.5F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(18, 66).addBox(-6.0F + OffsetX + armorOffsetX, 5.1F + OffsetY + armorOffsetY, -5.5F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(57, 41).addBox(-0.9F + OffsetX + armorOffsetX, 4.6F + OffsetY + armorOffsetY, -5.5F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(65, 18).addBox(-6.0F + OffsetX + armorOffsetX, 4.1F + OffsetY + armorOffsetY, -5.6F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(55, 38).addBox(-0.9F + OffsetX + armorOffsetX, 2.6F + OffsetY + armorOffsetY, -5.7F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(0, 56).addBox(-4.0F + OffsetX + armorOffsetX, 4.1F + OffsetY + armorOffsetY, -5.7F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(50, 65).addBox(-2.0F + OffsetX + armorOffsetX, 3.6F + OffsetY + armorOffsetY, -5.7F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(56, 65).addBox(-1.0F + OffsetX + armorOffsetX, 3.1F + OffsetY + armorOffsetY, -5.7F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(62, 65).addBox(-5.0F + OffsetX + armorOffsetX, 3.6F + OffsetY + armorOffsetY, -5.7F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(53, 56).addBox(-7.1F + OffsetX + armorOffsetX, 2.6F + OffsetY + armorOffsetY, -5.7F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(65, 9).addBox(-6.0F + OffsetX + armorOffsetX, 3.1F + OffsetY + armorOffsetY, -5.7F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(56, 0).addBox(-7.1F + OffsetX + armorOffsetX, 3.6F + OffsetY + armorOffsetY, -5.6F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(53, 49).addBox(-0.9F + OffsetX + armorOffsetX, 3.6F + OffsetY + armorOffsetY, -5.6F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(34, 54).addBox(-4.0F + OffsetX + armorOffsetX, 5.1F + OffsetY + armorOffsetY, -5.6F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(0, 65).addBox(-2.0F + OffsetX + armorOffsetX, 4.6F + OffsetY + armorOffsetY, -5.6F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(14, 65).addBox(-1.0F + OffsetX + armorOffsetX, 4.1F + OffsetY + armorOffsetY, -5.6F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(38, 65).addBox(-5.0F + OffsetX + armorOffsetX, 4.6F + OffsetY + armorOffsetY, -5.6F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(40, 55).addBox(-7.1F + OffsetX + armorOffsetX, 1.6F + OffsetY + armorOffsetY, -5.8F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(65, 35).addBox(-5.0F + OffsetX + armorOffsetX, 2.6F + OffsetY + armorOffsetY, -5.8F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(65, 46).addBox(-1.0F + OffsetX + armorOffsetX, 2.1F + OffsetY + armorOffsetY, -5.8F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(65, 49).addBox(-2.0F + OffsetX + armorOffsetX, 2.6F + OffsetY + armorOffsetY, -5.8F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(56, 4).addBox(-4.0F + OffsetX + armorOffsetX, 3.1F + OffsetY + armorOffsetY, -5.8F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(56, 14).addBox(-0.9F + OffsetX + armorOffsetX, 1.6F + OffsetY + armorOffsetY, -5.8F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(64, 43).addBox(-6.0F + OffsetX + armorOffsetX, 2.1F + OffsetY + armorOffsetY, -5.8F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(49, 14).addBox(-7.1F + OffsetX + armorOffsetX, 0.6F + OffsetY + armorOffsetY, -5.9F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 3.0F, 0.0F, false);
		bipedBody.setTextureOffset(14, 0).addBox(-6.0F + OffsetX + armorOffsetX, 0.1F + OffsetY + armorOffsetY, -6.0F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 7.0F, 0.0F, false);
		bipedBody.setTextureOffset(34, 64).addBox(-5.0F + OffsetX + armorOffsetX, 0.6F + OffsetY + armorOffsetY, -6.0F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(0, 15).addBox(-1.0F + OffsetX + armorOffsetX, 0.1F + OffsetY + armorOffsetY, -6.0F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 7.0F, 0.0F, false);
		bipedBody.setTextureOffset(64, 14).addBox(-2.0F + OffsetX + armorOffsetX, 0.6F + OffsetY + armorOffsetY, -6.0F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(0, 53).addBox(-4.0F + OffsetX + armorOffsetX, 1.1F + OffsetY + armorOffsetY, -6.0F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(16, 16).addBox(0.0F + OffsetX + armorOffsetX, -0.4F + OffsetY + armorOffsetY, -6.0F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 7.0F, 0.0F, false);
		bipedBody.setTextureOffset(0, 23).addBox(-7.0F + OffsetX + armorOffsetX, -0.4F + OffsetY + armorOffsetY, -6.0F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 7.0F, 0.0F, false);
		bipedBody.setTextureOffset(34, 50).addBox(-0.9F + OffsetX + armorOffsetX, 0.6F + OffsetY + armorOffsetY, -5.9F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 3.0F, 0.0F, false);
		bipedBody.setTextureOffset(53, 53).addBox(-4.0F + OffsetX + armorOffsetX, 2.1F + OffsetY + armorOffsetY, -5.9F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(64, 28).addBox(-2.0F + OffsetX + armorOffsetX, 1.6F + OffsetY + armorOffsetY, -5.9F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(22, 24).addBox(-1.0F + OffsetX + armorOffsetX, 1.1F + OffsetY + armorOffsetY, -5.9F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bipedBody.setTextureOffset(64, 31).addBox(-5.0F + OffsetX + armorOffsetX, 1.6F + OffsetY + armorOffsetY, -5.9F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(41, 50).addBox(-4.0F + OffsetX + armorOffsetX, 1.1F + OffsetY + armorOffsetY, -0.45F + OffsetZ + armorOffsetZ, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(10, 64).addBox(-2.0F + OffsetX + armorOffsetX, 0.6F + OffsetY + armorOffsetY, -0.45F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(24, 64).addBox(-5.0F + OffsetX + armorOffsetX, 0.6F + OffsetY + armorOffsetY, -0.45F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(32, 26).addBox(-6.0F + OffsetX + armorOffsetX, 1.1F + OffsetY + armorOffsetY, -5.9F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bipedBody.setTextureOffset(9, 9).addBox(-0.9F + OffsetX + armorOffsetX, 2.55F + OffsetY + armorOffsetY, -4.0F + OffsetZ + armorOffsetZ, 2.0F, 8.0F, 5.0F, 0.0F, false);
		bipedBody.setTextureOffset(16, 47).addBox(-1.0F + OffsetX + armorOffsetX, 1.05F + OffsetY + armorOffsetY, -0.5F + OffsetZ + armorOffsetZ, 1.0F, 9.0F, 2.0F, 0.0F, false);
		bipedBody.setTextureOffset(49, 49).addBox(-3.0F + OffsetX + armorOffsetX, 2.05F + OffsetY + armorOffsetY, 0.2F + OffsetZ + armorOffsetZ, 1.0F, 10.0F, 1.0F, 0.0F, false);
		bipedBody.setTextureOffset(30, 50).addBox(-5.0F + OffsetX + armorOffsetX, 1.55F + OffsetY + armorOffsetY, 0.2F + OffsetZ + armorOffsetZ, 1.0F, 10.0F, 1.0F, 0.0F, false);
		bipedBody.setTextureOffset(0, 0).addBox(-7.1F + OffsetX + armorOffsetX, 2.55F + OffsetY + armorOffsetY, -4.0F + OffsetZ + armorOffsetZ, 2.0F, 8.0F, 5.0F, 0.0F, false);
		bipedBody.setTextureOffset(22, 49).addBox(-2.0F + OffsetX + armorOffsetX, 1.55F + OffsetY + armorOffsetY, 0.2F + OffsetZ + armorOffsetZ, 1.0F, 10.0F, 1.0F, 0.0F, false);
		bipedBody.setTextureOffset(26, 49).addBox(-4.0F + OffsetX + armorOffsetX, 2.05F + OffsetY + armorOffsetY, 0.2F + OffsetZ + armorOffsetZ, 1.0F, 10.0F, 1.0F, 0.0F, false);
		bipedBody.setTextureOffset(14, 47).addBox(-6.0F + OffsetX + armorOffsetX, 10.0F + OffsetY + armorOffsetY, 0.0F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bipedBody.setTextureOffset(44, 24).addBox(-1.0F + OffsetX + armorOffsetX, 10.0F + OffsetY + armorOffsetY, 0.0F + OffsetZ + armorOffsetZ, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bipedBody.setTextureOffset(68, 27).addBox(0.0F + OffsetX + armorOffsetX, 0.55F + OffsetY + armorOffsetY, 0.0F + OffsetZ + armorOffsetZ, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bipedBody.setTextureOffset(68, 12).addBox(-7.0F + OffsetX + armorOffsetX, 0.55F + OffsetY + armorOffsetY, 0.0F + OffsetZ + armorOffsetZ, 1.0F, 2.0F, 1.0F, 0.0F, false);

		bipedRightArm = new ModelRenderer(this);
		bipedRightArm.setRotationPoint(-4.0F, 24.25F, -2.0F);
		bipedRightArm.setTextureOffset(26, 26).addBox(-0.5F + rightArmOffsetX + OffsetX, 1.75F + rightArmOffsetY + OffsetY, 0.0F + rightArmOffsetZ + OffsetZ, 1.0F, 9.0F, 4.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(6, 31).addBox(-4.0F + rightArmOffsetX + OffsetX, 6.5F + rightArmOffsetY + OffsetY, -1.2F + rightArmOffsetZ + OffsetZ, 4.0F, 3.0F, 1.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(48, 28).addBox(-4.5F + rightArmOffsetX + OffsetX, 6.0F + rightArmOffsetY + OffsetY, -1.0F + rightArmOffsetZ + OffsetZ, 4.0F, 1.0F, 1.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(20, 39).addBox(-4.0F + rightArmOffsetX + OffsetX, 1.75F + rightArmOffsetY + OffsetY, -0.5F + rightArmOffsetZ + OffsetZ, 4.0F, 9.0F, 1.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(38, 31).addBox(-6.0F + rightArmOffsetX + OffsetX, 0.75F + rightArmOffsetY + OffsetY, -1.5F + rightArmOffsetZ + OffsetZ, 6.0F, 1.0F, 2.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(47, 10).addBox(-5.0F + rightArmOffsetX + OffsetX, -2.25F + rightArmOffsetY + OffsetY, -1.0F + rightArmOffsetZ + OffsetZ, 5.0F, 3.0F, 1.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(35, 12).addBox(-1.0F + rightArmOffsetX + OffsetX, -2.25F + rightArmOffsetY + OffsetY, -1.5F + rightArmOffsetZ + OffsetZ, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(31, 5).addBox(-1.0F + rightArmOffsetX + OffsetX, -2.75F + rightArmOffsetY + OffsetY, -1.0F + rightArmOffsetZ + OffsetZ, 1.0F, 1.0F, 6.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(52, 34).addBox(-5.0F + rightArmOffsetX + OffsetX, -2.75F + rightArmOffsetY + OffsetY, 0.0F + rightArmOffsetZ + OffsetZ, 4.0F, 1.0F, 1.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(35, 12).addBox(-4.0F + rightArmOffsetX + OffsetX, -2.25F + rightArmOffsetY + OffsetY, 0.0F + rightArmOffsetZ + OffsetZ, 4.0F, 1.0F, 4.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(52, 30).addBox(-5.0F + rightArmOffsetX + OffsetX, -2.75F + rightArmOffsetY + OffsetY, 3.0F + rightArmOffsetZ + OffsetZ, 4.0F, 1.0F, 1.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(40, 43).addBox(-5.0F + rightArmOffsetX + OffsetX, -2.25F + rightArmOffsetY + OffsetY, 0.0F + rightArmOffsetZ + OffsetZ, 1.0F, 3.0F, 4.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(0, 31).addBox(-5.5F + rightArmOffsetX + OffsetX, -2.25F + rightArmOffsetY + OffsetY, 3.0F + rightArmOffsetZ + OffsetZ, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(35, 0).addBox(-5.5F + rightArmOffsetX + OffsetX, -2.25F + rightArmOffsetY + OffsetY, 0.0F + rightArmOffsetZ + OffsetZ, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(49, 0).addBox(-6.0F + rightArmOffsetX + OffsetX, 0.75F + rightArmOffsetY + OffsetY, 0.5F + rightArmOffsetZ + OffsetZ, 2.0F, 1.0F, 3.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(35, 17).addBox(-6.0F + rightArmOffsetX + OffsetX, 0.75F + rightArmOffsetY + OffsetY, 3.5F + rightArmOffsetZ + OffsetZ, 6.0F, 1.0F, 2.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(46, 43).addBox(-5.0F + rightArmOffsetX + OffsetX, -2.25F + rightArmOffsetY + OffsetY, 4.0F + rightArmOffsetZ + OffsetZ, 5.0F, 3.0F, 1.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(40, 43).addBox(-1.0F + rightArmOffsetX + OffsetX, -2.25F + rightArmOffsetY + OffsetY, 4.5F + rightArmOffsetZ + OffsetZ, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(10, 37).addBox(-4.0F + rightArmOffsetX + OffsetX, 1.75F + rightArmOffsetY + OffsetY, 3.5F + rightArmOffsetZ + OffsetZ, 4.0F, 9.0F, 1.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(46, 60).addBox(-4.7F + rightArmOffsetX + OffsetX, 5.5F + rightArmOffsetY + OffsetY, 2.1F + rightArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(0, 31).addBox(-4.5F + rightArmOffsetX + OffsetX, 1.75F + rightArmOffsetY + OffsetY, 0.0F + rightArmOffsetZ + OffsetZ, 1.0F, 9.0F, 4.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(26, 61).addBox(-4.9F + rightArmOffsetX + OffsetX, 5.0F + rightArmOffsetY + OffsetY, 1.0F + rightArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(38, 61).addBox(-5.0F + rightArmOffsetX + OffsetX, 6.0F + rightArmOffsetY + OffsetY, 1.0F + rightArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(31, 8).addBox(-5.1F + rightArmOffsetX + OffsetX, 7.0F + rightArmOffsetY + OffsetY, 1.0F + rightArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(31, 5).addBox(-5.1F + rightArmOffsetX + OffsetX, 8.0F + rightArmOffsetY + OffsetY, 1.0F + rightArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(60, 34).addBox(-4.8F + rightArmOffsetX + OffsetX, 6.5F + rightArmOffsetY + OffsetY, 2.1F + rightArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(12, 61).addBox(-4.9F + rightArmOffsetX + OffsetX, 7.5F + rightArmOffsetY + OffsetY, 2.1F + rightArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(47, 38).addBox(-4.5F + rightArmOffsetX + OffsetX, 6.0F + rightArmOffsetY + OffsetY, 4.0F + rightArmOffsetZ + OffsetZ, 4.0F, 1.0F, 1.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(9, 28).addBox(-4.6F + rightArmOffsetX + OffsetX, 7.0F + rightArmOffsetY + OffsetY, 4.0F + rightArmOffsetZ + OffsetZ, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(48, 24).addBox(-4.0F + rightArmOffsetX + OffsetX, 6.5F + rightArmOffsetY + OffsetY, 4.25F + rightArmOffsetZ + OffsetZ, 4.0F, 3.0F, 1.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(4, 13).addBox(-4.6F + rightArmOffsetX + OffsetX, 8.0F + rightArmOffsetY + OffsetY, 4.0F + rightArmOffsetZ + OffsetZ, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(23, 5).addBox(-4.5F + rightArmOffsetX + OffsetX, 9.0F + rightArmOffsetY + OffsetY, 4.0F + rightArmOffsetZ + OffsetZ, 4.0F, 1.0F, 1.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(0, 23).addBox(-4.8F + rightArmOffsetX + OffsetX, 8.5F + rightArmOffsetY + OffsetY, 2.1F + rightArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(0, 16).addBox(-4.7F + rightArmOffsetX + OffsetX, 9.5F + rightArmOffsetY + OffsetY, 2.1F + rightArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(0, 19).addBox(-5.0F + rightArmOffsetX + OffsetX, 9.0F + rightArmOffsetY + OffsetY, 1.0F + rightArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(0, 13).addBox(-4.9F + rightArmOffsetX + OffsetX, 10.0F + rightArmOffsetY + OffsetY, 1.0F + rightArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(14, 4).addBox(-4.7F + rightArmOffsetX + OffsetX, 9.5F + rightArmOffsetY + OffsetY, -0.1F + rightArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(38, 37).addBox(-4.5F + rightArmOffsetX + OffsetX, 9.0F + rightArmOffsetY + OffsetY, -1.0F + rightArmOffsetZ + OffsetZ, 4.0F, 1.0F, 1.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(0, 26).addBox(-4.8F + rightArmOffsetX + OffsetX, 8.5F + rightArmOffsetY + OffsetY, -0.1F + rightArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(18, 12).addBox(-4.6F + rightArmOffsetX + OffsetX, 8.0F + rightArmOffsetY + OffsetY, -1.0F + rightArmOffsetZ + OffsetZ, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(25, 21).addBox(-4.6F + rightArmOffsetX + OffsetX, 7.0F + rightArmOffsetY + OffsetY, -1.0F + rightArmOffsetZ + OffsetZ, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(6, 45).addBox(-4.9F + rightArmOffsetX + OffsetX, 7.5F + rightArmOffsetY + OffsetY, -0.1F + rightArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(6, 61).addBox(-4.8F + rightArmOffsetX + OffsetX, 6.5F + rightArmOffsetY + OffsetY, -0.1F + rightArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(60, 30).addBox(-4.7F + rightArmOffsetX + OffsetX, 5.5F + rightArmOffsetY + OffsetY, -0.1F + rightArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedRightArm.setTextureOffset(28, 21).addBox(-4.0F + rightArmOffsetX + OffsetX, 10.0F + rightArmOffsetY + OffsetY, 0.0F + rightArmOffsetZ + OffsetZ, 4.0F, 1.0F, 4.0F, 0.0F, false);

		bipedLeftArm = new ModelRenderer(this);
		bipedLeftArm.setRotationPoint(8.5F, 20.25F, -3.0F);
		bipedLeftArm.setTextureOffset(30, 33).addBox(-4.5F + leftArmOffsetX + OffsetX, 1.25F + leftArmOffsetY + OffsetY, 0.0F + leftArmOffsetZ + OffsetZ, 1.0F, 1.0F, 6.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(62, 68).addBox(-4.5F + leftArmOffsetX + OffsetX, 1.75F + leftArmOffsetY + OffsetY, -0.5F + leftArmOffsetZ + OffsetZ, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(9, 0).addBox(-4.5F + leftArmOffsetX + OffsetX, 1.75F + leftArmOffsetY + OffsetY, 0.0F + leftArmOffsetZ + OffsetZ, 5.0F, 3.0F, 1.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(52, 20).addBox(-3.5F + leftArmOffsetX + OffsetX, 1.25F + leftArmOffsetY + OffsetY, 1.0F + leftArmOffsetZ + OffsetZ, 4.0F, 1.0F, 1.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(0, 44).addBox(-0.5F + leftArmOffsetX + OffsetX, 1.75F + leftArmOffsetY + OffsetY, 1.0F + leftArmOffsetZ + OffsetZ, 1.0F, 3.0F, 4.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(52, 22).addBox(-3.5F + leftArmOffsetX + OffsetX, 1.25F + leftArmOffsetY + OffsetY, 4.0F + leftArmOffsetZ + OffsetZ, 4.0F, 1.0F, 1.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(36, 26).addBox(-4.5F + leftArmOffsetX + OffsetX, 1.75F + leftArmOffsetY + OffsetY, 1.0F + leftArmOffsetZ + OffsetZ, 4.0F, 1.0F, 4.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(23, 0).addBox(0.0F + leftArmOffsetX + OffsetX, 1.75F + leftArmOffsetY + OffsetY, 4.0F + leftArmOffsetZ + OffsetZ, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(0, 0).addBox(0.0F + leftArmOffsetX + OffsetX, 1.75F + leftArmOffsetY + OffsetY, 1.0F + leftArmOffsetZ + OffsetZ, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(40, 20).addBox(-4.5F + leftArmOffsetX + OffsetX, 1.75F + leftArmOffsetY + OffsetY, 5.0F + leftArmOffsetZ + OffsetZ, 5.0F, 3.0F, 1.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(38, 34).addBox(-4.5F + leftArmOffsetX + OffsetX, 4.75F + leftArmOffsetY + OffsetY, 4.5F + leftArmOffsetZ + OffsetZ, 6.0F, 1.0F, 2.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(49, 4).addBox(-0.5F + leftArmOffsetX + OffsetX, 4.75F + leftArmOffsetY + OffsetY, 1.5F + leftArmOffsetZ + OffsetZ, 2.0F, 1.0F, 3.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(40, 40).addBox(-4.5F + leftArmOffsetX + OffsetX, 4.75F + leftArmOffsetY + OffsetY, -0.5F + leftArmOffsetZ + OffsetZ, 6.0F, 1.0F, 2.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(39, 0).addBox(-4.5F + leftArmOffsetX + OffsetX, 5.75F + leftArmOffsetY + OffsetY, 0.5F + leftArmOffsetZ + OffsetZ, 4.0F, 9.0F, 1.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(25, 8).addBox(-1.0F + leftArmOffsetX + OffsetX, 5.75F + leftArmOffsetY + OffsetY, 1.0F + leftArmOffsetZ + OffsetZ, 1.0F, 9.0F, 4.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(0, 44).addBox(-4.5F + leftArmOffsetX + OffsetX, 1.75F + leftArmOffsetY + OffsetY, 5.5F + leftArmOffsetZ + OffsetZ, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(30, 40).addBox(-4.5F + leftArmOffsetX + OffsetX, 5.75F + leftArmOffsetY + OffsetY, 4.5F + leftArmOffsetZ + OffsetZ, 4.0F, 9.0F, 1.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(16, 24).addBox(-5.0F + leftArmOffsetX + OffsetX, 5.75F + leftArmOffsetY + OffsetY, 1.0F + leftArmOffsetZ + OffsetZ, 1.0F, 9.0F, 4.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(18, 8).addBox(-4.5F + leftArmOffsetX + OffsetX, 10.5F + leftArmOffsetY + OffsetY, 5.25F + leftArmOffsetZ + OffsetZ, 4.0F, 3.0F, 1.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(50, 47).addBox(-4.0F + leftArmOffsetX + OffsetX, 10.0F + leftArmOffsetY + OffsetY, 5.0F + leftArmOffsetZ + OffsetZ, 4.0F, 1.0F, 1.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(61, 17).addBox(-0.5F + leftArmOffsetX + OffsetX, 9.0F + leftArmOffsetY + OffsetY, 2.0F + leftArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(50, 62).addBox(-0.4F + leftArmOffsetX + OffsetX, 10.0F + leftArmOffsetY + OffsetY, 2.0F + leftArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(16, 62).addBox(-0.65F + leftArmOffsetX + OffsetX, 10.5F + leftArmOffsetY + OffsetY, 0.9F + leftArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(61, 37).addBox(-0.75F + leftArmOffsetX + OffsetX, 9.5F + leftArmOffsetY + OffsetY, 0.9F + leftArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(0, 62).addBox(-0.75F + leftArmOffsetX + OffsetX, 9.5F + leftArmOffsetY + OffsetY, 3.1F + leftArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(42, 62).addBox(-0.65F + leftArmOffsetX + OffsetX, 10.5F + leftArmOffsetY + OffsetY, 3.1F + leftArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(26, 28).addBox(-0.9F + leftArmOffsetX + OffsetX, 11.0F + leftArmOffsetY + OffsetY, 5.0F + leftArmOffsetZ + OffsetZ, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(62, 1).addBox(-0.55F + leftArmOffsetX + OffsetX, 11.5F + leftArmOffsetY + OffsetY, 3.1F + leftArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(30, 63).addBox(-0.65F + leftArmOffsetX + OffsetX, 12.5F + leftArmOffsetY + OffsetY, 3.1F + leftArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(36, 31).addBox(-0.9F + leftArmOffsetX + OffsetX, 12.0F + leftArmOffsetY + OffsetY, 5.0F + leftArmOffsetZ + OffsetZ, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(51, 18).addBox(-4.0F + leftArmOffsetX + OffsetX, 13.0F + leftArmOffsetY + OffsetY, 5.0F + leftArmOffsetZ + OffsetZ, 4.0F, 1.0F, 1.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(63, 25).addBox(-0.75F + leftArmOffsetX + OffsetX, 13.5F + leftArmOffsetY + OffsetY, 3.1F + leftArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(56, 62).addBox(-0.3F + leftArmOffsetX + OffsetX, 11.0F + leftArmOffsetY + OffsetY, 2.0F + leftArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(62, 62).addBox(-0.3F + leftArmOffsetX + OffsetX, 12.0F + leftArmOffsetY + OffsetY, 2.0F + leftArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(20, 63).addBox(-0.4F + leftArmOffsetX + OffsetX, 13.0F + leftArmOffsetY + OffsetY, 2.0F + leftArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(4, 64).addBox(-0.5F + leftArmOffsetX + OffsetX, 14.0F + leftArmOffsetY + OffsetY, 2.0F + leftArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(23, 0).addBox(-4.5F + leftArmOffsetX + OffsetX, 14.0F + leftArmOffsetY + OffsetY, 1.0F + leftArmOffsetZ + OffsetZ, 4.0F, 1.0F, 4.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(63, 40).addBox(-0.75F + leftArmOffsetX + OffsetX, 13.5F + leftArmOffsetY + OffsetY, 0.9F + leftArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(46, 63).addBox(-0.65F + leftArmOffsetX + OffsetX, 12.5F + leftArmOffsetY + OffsetY, 0.9F + leftArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(62, 5).addBox(-0.55F + leftArmOffsetX + OffsetX, 11.5F + leftArmOffsetY + OffsetY, 0.9F + leftArmOffsetZ + OffsetZ, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(20, 37).addBox(-0.9F + leftArmOffsetX + OffsetX, 12.0F + leftArmOffsetY + OffsetY, 0.0F + leftArmOffsetZ + OffsetZ, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(0, 51).addBox(-4.0F + leftArmOffsetX + OffsetX, 13.0F + leftArmOffsetY + OffsetY, 0.0F + leftArmOffsetZ + OffsetZ, 4.0F, 1.0F, 1.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(9, 24).addBox(-4.5F + leftArmOffsetX + OffsetX, 10.5F + leftArmOffsetY + OffsetY, -0.2F + leftArmOffsetZ + OffsetZ, 4.0F, 3.0F, 1.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(10, 35).addBox(-0.9F + leftArmOffsetX + OffsetX, 11.0F + leftArmOffsetY + OffsetY, 0.0F + leftArmOffsetZ + OffsetZ, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bipedLeftArm.setTextureOffset(49, 8).addBox(-4.0F + leftArmOffsetX + OffsetX, 10.0F + leftArmOffsetY + OffsetY, 0.0F + leftArmOffsetZ + OffsetZ, 4.0F, 1.0F, 1.0F, 0.0F, false);

	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		bipedBody.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
		bipedRightArm.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
		bipedLeftArm.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
	}

}