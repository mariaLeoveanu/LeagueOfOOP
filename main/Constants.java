package main;

public final class Constants {
    private Constants() { }


    // Constants used in Knight.class
    public static final int XP_FORMULA_MINUEND = 200;
    public static final int XP_FORMULA_MULTIPLIER = 40;
    public static final int BASE_XP = 250;
    public static final int XP_PER_LEVEL = 50;
    public static final int KNIGHT_BASE_HP = 900;
    public static final int KNIGHT_HP_PER_LEVEL = 80;
    public static final int EXECUTE_BASE_DAMAGE = 200;
    public static final int EXECUTE_DAMAGE_PER_LEVEL = 30;
    public static final int SLAM_BASE_DAMAGE = 100;
    public static final int SLAM_DAMAGE_PER_LEVEL = 40;
    public static final float KNIGHT_LAND_MULTIPLIER = 1.15f;
    public static final float EXECUTE_BASE_HP_LIMIT = 0.2f;
    public static final float EXECUTE_HP_LIMIT_PER_LEVEL = 0.01f;
    public static final float EXECUTE_ROGUE_MULTIPLIER = 1.15f;
    public static final float SLAM_ROGUE_MULTIPLIER = 0.8f;
    public static final float SLAM_KNIGHT_MULTIPLIER = 1.2f;
    public static final float EXECUTE_PYROMANCER_MULTIPLIER = 1.1f;
    public static final float SLAM_PYROMANCER_MULTIPLIER = 0.9f;
    public static final float EXECUTE_WIZARD_MULTIPLIER = 0.8f;
    public static final float SLAM_WIZARD_MULTIPLIER = 1.05f;


    // Constants used in Pyromancer.class
    public static final int PYROMANCER_BASE_HP = 500;
    public static final int PYROMANCER_HP_PER_LEVEL = 50;
    public static final int FIREBLAST_BASE_DAMAGE = 350;
    public static final int FIREBLAST_DAMAGE_PER_LEVEL = 50;
    public static final int IGNITE_BASE_DAMAGE = 150;
    public static final int IGNITE_DAMAGE_PER_LEVEL = 20;
    public static final int IGNITE_DAMAGE_OVERTIME = 50;
    public static final int IGNITE_DAMAGE_OVERTIME_PER_LEVEL = 30;
    public static final float PYROMANCER_LAND_MULTIPLIER = 1.25f;
    public static final float PYROMANCER_ABILITY_KNIGHT_MULTIPLIER = 1.2f;
    public static final float PYROMANCER_ABILITY_PYROMANCER_MULTIPLIER = 0.9f;
    public static final float PYROMANCER_ABILITY_WIZARD_MULTIPLIER = 1.05f;
    public static final float PYROMANCER_ABILITY_ROGUE_MULTIPLIER = 0.8f;


    // Constants used in Rogue.class
    public static final int ROGUE_BASE_HP = 600;
    public static final int ROGUE_HP_PER_LEVEL = 40;
    public static final int BACKSTAB_BASE_DAMAGE = 200;
    public static final int BACKSTAB_DAMAGE_PER_LEVEL = 20;
    public static final int PARALYSIS_BASE_DAMAGE = 40;
    public static final int PARALYSIS_DAMAGE_PER_LEVEL = 10;
    public static final float ROGUE_LAND_MULTIPLIER = 1.15f;
    public static final int ROGUE_PARALYSIS_MIN_ROUNDS = 3;
    public static final float BACKSTAB_CRITICAL_BONUS = 1.5f;
    public static final int ROGUE_MAX_STREAK = 3;
    public static final int ROGUE_PARALYSIS_MAX_ROUNDS = 6;
    public static final float ROGUE_ABILITY_WIZARD_BONUS = 1.25f;
    public static final float BACKSTAB_ROGUE_MULTIPLIER = 1.2f;
    public static final float PRALYSIS_ROGUE_MULTIPLIER = 0.9f;
    public static final float BACKSTAB_KNIGHT_MULTIPLIER = 0.9f;
    public static final float PRALYSIS_KNIGHT_MULTIPLIER = 0.8f;
    public static final float BACKSTAB_PYROMANCER_MULTIPLIER = 1.25f;
    public static final float PRALYSIS_PYROMANCER_MULTIPLIER = 1.2f;


    // Constants used in Wizard.class
    public static final int WIZARD_BASE_HP = 400;
    public static final int WIZARD_HP_PER_LEVEL = 30;
    public static final float DRAIN_BASE_PERCENTAGE = 0.2f;
    public static final float DRAIN_P_PER_ROUND = 0.05f;
    public static final float DEFLECT_BASE_PERCENTAGE = 0.35f;
    public static final float DEFLECT_P_PER_ROUND = 0.02f;
    public static final float DEFLECT_ROGUE_MULTIPLIER = 1.2f;
    public static final float DRAIN_ROGUE_MULTIPLIER = 0.8f;
    public static final float DEFLECT_KNIGHT_MULTIPLIER = 1.4f;
    public static final float DRAIN_KNIGHT_MULTIPLIER = 1.2f;
    public static final float DEFLECT_PYROMANCER_MULTIPLIER = 1.3f;
    public static final float DRAIN_PYROMANCER_MULTIPLIER = 0.9f;
    public static final float DRAIN_WIZARD_MULTIPLIER = 1.05f;
    public static final float WIZARD_LAND_MULTIPLIER = 1.1f;
    public static final float DRAIN_MAX_HP_MULTIPLIER = 0.3f;

}
