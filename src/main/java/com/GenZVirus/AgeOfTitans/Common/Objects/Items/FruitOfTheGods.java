package com.GenZVirus.AgeOfTitans.Common.Objects.Items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class FruitOfTheGods extends Item implements PricedItem {

	private int price = 0;
	
	public FruitOfTheGods(Properties properties) {
		super(properties);
		this.price = 500;
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent(""));
		tooltip.add(new StringTextComponent(
				"\u00A75Upon eaten the user becomes more powerful than before."));
		tooltip.add(new StringTextComponent(""));
		tooltip.add(new StringTextComponent("The item will be consumed on use."));

		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int getPrice() {
		return this.price;
	}

}
