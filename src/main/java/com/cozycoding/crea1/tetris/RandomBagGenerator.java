package com.cozycoding.crea1.tetris;

import com.cozycoding.crea1.tetris.blocks.IBlock;
import com.cozycoding.crea1.tetris.blocks.JBlock;
import com.cozycoding.crea1.tetris.blocks.LBlock;
import com.cozycoding.crea1.tetris.blocks.OBlock;
import com.cozycoding.crea1.tetris.blocks.SBlock;
import com.cozycoding.crea1.tetris.blocks.TBlock;
import com.cozycoding.crea1.tetris.blocks.TetrisBlock;
import com.cozycoding.crea1.tetris.blocks.ZBlock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class takes all 7 Block types and generates a random bag.
 * http://tetris.wikia.com/wiki/Random_Generator
 *
 * @author Marius Kristensen
 */
public class RandomBagGenerator {
    
    public List<TetrisBlock> createNewBag() {

        List<TetrisBlock> bag = new ArrayList<>();
        bag.add(new IBlock());
        bag.add(new JBlock());
        bag.add(new LBlock());
        bag.add(new OBlock());
        bag.add(new SBlock());
        bag.add(new TBlock());
        bag.add(new ZBlock());

        Collections.shuffle(bag);

        return bag;
    }
}
