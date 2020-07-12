package paperdomo101.aether_rewoven.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import paperdomo101.aether_rewoven.registry.AetherArmorMaterials;

public class AetherArmorItem extends ArmorItem {
    private final AetherArmorMaterials material;

    public AetherArmorItem(AetherArmorMaterials materialIn, EquipmentSlot slot, Item.Settings builder) {
        super(materialIn, slot, builder);
        this.material = materialIn;

    }

    public AetherArmorMaterials getArmorMaterial() {
        return this.material;
    }
}