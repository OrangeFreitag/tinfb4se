package de.codecrunch.model.unit;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class M_FastUnitTest {

    private int speed = 4;
    private int maxLife = 200;

    @Test
    public void m_FastUnit_shouldCreateFastUnit() {
        int expected[] = {speed,maxLife,maxLife};

        MA_Unit unit = new M_FastUnit();
        int actual_speed = unit.getSpeed();
        int actual_maxLife = unit.getMaxLife();
        int actual_currentLife = unit.getCurrentLife();
        int actual[] = {actual_speed,actual_maxLife,actual_currentLife};

        assertArrayEquals(expected,actual);
    }

    @Test
    public void getSpeed_shouldReturnCurrentSpeed() {
        int expected = speed;

        M_FastUnit unit = new M_FastUnit();
        int actual = unit.getSpeed();

        assertEquals(expected,actual);
    }

    @Test
    public void setSpeed_canBeChanged_speedShouldBeChanged() {
        int expected = speed+1;

        M_FastUnit unit = new M_FastUnit();
        unit.setSpeed(speed+1);
        int actual = unit.getSpeed();

        assertEquals(expected,actual);
    }

    @Test
    public void setSpeed_canNotBeNegative_speedShouldBeUnchanged() {
        int expected = speed;

        M_FastUnit unit = new M_FastUnit();
        unit.setSpeed(-1);
        int actual = unit.getSpeed();

        assertEquals(expected,actual);
    }

    @Test
    public void getMaxLife_shouldReturnCurrentMaxLife() {
        int expected = maxLife;

        M_FastUnit unit = new M_FastUnit();
        int actual = unit.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setMaxLife_canBeChanged_maxLifeShouldBeChanged() {
        int expected = maxLife+100;

        M_FastUnit unit = new M_FastUnit();
        unit.setMaxLife(maxLife+100);
        int actual = unit.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setMaxLife_canNotBeZero_maxLifeShouldBeUnchanged() {
        int expected = maxLife;

        M_FastUnit unit = new M_FastUnit();
        unit.setMaxLife(0);
        int actual = unit.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setMaxLife_canNotBeNegative_maxLifeShouldBeUnchanged() {
        int expected = maxLife;

        M_FastUnit unit = new M_FastUnit();
        unit.setMaxLife(-1);
        int actual = unit.getMaxLife();

        assertEquals(expected,actual);
    }

    @Test
    public void getCurrentLife_shouldReturnCurrentLife() {
        int expected = maxLife;

        M_FastUnit unit = new M_FastUnit();
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setCurrentLife_lowerThanMaxLife_currentLifeShouldBeChanged() {
        int expected = maxLife-1;

        M_FastUnit unit = new M_FastUnit();
        unit.setCurrentLife(maxLife-1);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void setCurrentLife_higherThanMaxLife_currentLifeShouldBeMaxLife() {
        int expected = maxLife;

        M_FastUnit unit = new M_FastUnit();
        unit.setCurrentLife(maxLife+1);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void takeDamage_damageLowerThanLife_currentLifeShouldBeOne() {
        int expected = 1;

        M_FastUnit unit = new M_FastUnit();
        unit.takeDamage(maxLife-1);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void takeDamage_damageHigherThanLife_currentLifeShouldBeZero(){
        int expected = 0;

        M_FastUnit unit = new M_FastUnit();
        unit.takeDamage(maxLife+1);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void heal_overheal_CurrentLifeShouldBeMaxLife(){
        int expected = maxLife;

        M_FastUnit unit = new M_FastUnit();
        unit.setCurrentLife(1);
        unit.heal(maxLife+1);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void heal_heal_currentLifeShouldBeOneLowerThanMaxLife(){
        int expected = maxLife-1;

        M_FastUnit unit = new M_FastUnit();
        unit.setCurrentLife(1);
        unit.heal(maxLife-2);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }

    @Test
    public void heal_healDeadDoesNotRevive_currentLifeShouldBeZero(){
        int expected = 0;

        M_FastUnit unit = new M_FastUnit();
        unit.setCurrentLife(0);
        unit.heal(1);
        int actual = unit.getCurrentLife();

        assertEquals(expected,actual);
    }
}