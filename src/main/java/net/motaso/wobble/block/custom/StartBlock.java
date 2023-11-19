package net.motaso.wobble.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Random;

import static java.lang.Thread.sleep;

public class StartBlock extends Block {

    public static final BooleanProperty STARTED = BooleanProperty.create("started");
    public static final IntegerProperty WAVE = IntegerProperty.create("wave", 0, 999);
    //public static final IntegerProperty MOBNUMBER = IntegerProperty.create("mobnumber", 0, 9999);


    public StartBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(STARTED, false));
        this.registerDefaultState(this.defaultBlockState().setValue(WAVE, 0));
        //this.registerDefaultState(this.defaultBlockState().setValue(MOBNUMBER, 0));
    }


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {
            boolean started = pState.getValue(STARTED);
            int wave = pState.getValue(WAVE);
            if (!started) {
                pLevel.setBlock(pPos, pState.setValue(STARTED, true), 3);
                //pLevel.setBlock(pPos, pState.setValue(MOBNUMBER, 0), 3);

                //pLevel.scheduleTick(pPos, this, 0);
                spawnWave(pState, pLevel, pPos, 1.0);
                pLevel.setBlock(pPos, pState.setValue(WAVE, wave + 1), 3);
            }
        }

        return InteractionResult.SUCCESS;
    }




    public void tick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        spawnWave(pState, pLevel, pPos, 1);
    }

    private double getRandomMobPositionOffset() {
        Random random = new Random();
        return random.nextDouble(1) - 1;
    }

    private void spawnWave(BlockState pState, Level pLevel, BlockPos pPos, double delay) {
        EntityType[] wave = getWave(pState.getValue(WAVE));
        EntityType pMob;
        Entity mob;

        for (int i = 0; i < wave.length; i++) {
            pMob = wave[i];
            mob = pMob.create(pLevel);
            if (mob instanceof Mob) {
                double d0 = pPos.getX() + this.getRandomMobPositionOffset();
                double d1 = pPos.getY()+1;
                double d2 = pPos.getZ() + this.getRandomMobPositionOffset();
                Random random = new Random();
                float k = random.nextFloat(361);
                mob.moveTo(d0, d1, d2, k, 0.0F);
                ((Mob) mob).setPersistenceRequired();
                pLevel.addFreshEntity(mob);
                try {
                    sleep((long) (delay * 1000)); //not good
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }


        //pLevel.scheduleTick(pPos, this, 30);

    }



    private EntityType[] getWave(int wave) {
        switch (wave) {
            case 0:
                return new EntityType[]{EntityType.ZOMBIE, EntityType.SKELETON, EntityType.WITCH};
            case 1:
                return new EntityType[]{EntityType.BLAZE, EntityType.GIANT};
            default:
                return new EntityType[]{};
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(STARTED);
        pBuilder.add(WAVE);
        //pBuilder.add(MOBNUMBER);
    }
}
