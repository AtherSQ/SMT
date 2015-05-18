package timaxa007.smt;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TestBlock extends Block {

	public TestBlock() {
		super(Material.iron);
		this.setStepSound(soundTypeWood);
		this.setCreativeTab(CoreSMT.tab_smt);
		this.setHardness(0.1F);
		this.setResistance(10.0F);
		this.setLightLevel(0.0F);
		this.setLightOpacity(1);
		this.setBlockTextureName("timaxa007:test_block");
		this.setBlockName("block_test");
	}

}