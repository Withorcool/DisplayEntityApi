package com.withorcc.displayentityapi;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Display;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.TextDisplay;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Transformation;

public class DisplayEntity {
    public static void Text(Location loc, String text, Color bg, Display.Billboard style, int linewidth){
        TextDisplay e = loc.getWorld().spawn(loc, TextDisplay.class);
        e.setText(text);

        e.setBackgroundColor(bg);
        e.setLineWidth(linewidth);
        e.setBillboard(style);
    }
    public static void Block(Location loc, Material material, int scale){
        BlockDisplay block = loc.getWorld().spawn(loc, BlockDisplay.class);
        block.setBlock(Bukkit.createBlockData(material));

        Transformation transformation = block.getTransformation();
        transformation.getScale().set(scale);

        block.setTransformation(transformation);
    }
    public static void Item(Location loc, Material material, int scale, float x, float y,float z, float vievrange, float shadowradius, float shadowstrength, int width, int height, Display.Billboard style, Color color, int blocklight, int skylight){
        ItemDisplay item = loc.getWorld().spawn(loc, ItemDisplay.class);
        item.setItemStack(new ItemStack(material));

        Transformation transformation = item.getTransformation();

        transformation.getScale().set(scale);

        transformation.getLeftRotation().x = x;
        transformation.getLeftRotation().y = y;
        transformation.getLeftRotation().z = z;

        item.setTransformation(transformation);

        item.setViewRange(vievrange);
        item.setShadowRadius(shadowradius);
        item.setShadowStrength(shadowstrength);

        item.setDisplayWidth(width);
        item.setDisplayHeight(height);

        item.setBillboard(style);

        item.setGlowColorOverride(color);

        item.setBrightness(new Display.Brightness(blocklight, skylight));
    }
}
