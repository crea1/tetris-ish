package com.cozycoding.crea1.tetris;

import com.cozycoding.crea1.tetris.blocks.TetrisBlock;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Marius Kristensen
 */
public class RandomBagGeneratorTest {

    private RandomBagGenerator bagGenerator;

    @Before
    public void setUp() throws Exception {
        bagGenerator = new RandomBagGenerator();
    }

    @Test
    public void testNumberOfBlocksInBag() throws Exception {

        List<TetrisBlock> bag = bagGenerator.createNewBag();
        assertTrue(bag.size() == 7);
    }

    @Test
    public void testThatIBlockIsInBag() throws Exception {
        List<TetrisBlock> bag = bagGenerator.createNewBag();
        List<TetrisBlock> bag2 = bagGenerator.createNewBag();

        //This have a very small chance of failing if the two bags are created equal
        assertNotEquals(bag, bag2);
    }
}
