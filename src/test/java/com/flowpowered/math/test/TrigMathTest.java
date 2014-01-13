/*
 * This file is part of Flow Math, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2013 Spout LLC <http://www.spout.org/>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.flowpowered.math.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.flowpowered.math.TrigMath;
import com.flowpowered.math.vector.Vector2d;
import com.flowpowered.math.vector.Vector2f;
import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3f;

public class TrigMathTest {
    private void testValue(float angle, float result, float realValue) {
        assertTrue("angle=" + angle + " expected " + realValue + " but got " + result, Math.abs(result - realValue) < 0.0001);
    }

    private void testValueD(double angle, double result, double realValue) {
        assertTrue("angle=" + angle + " expected " + realValue + " but got " + result, Math.abs(result - realValue) < 0.000002);
    }

    private void testSin(float value) {
        testValue(value, TrigMath.sin(value), (float) Math.sin(value));
    }

    private void testCos(float value) {
        testValue(value, TrigMath.cos(value), (float) Math.cos(value));
    }

    private void testSin(double value) {
        testValueD(value, TrigMath.sin(value), Math.sin(value));
    }

    private void testCos(double value) {
        testValueD(value, TrigMath.cos(value), Math.cos(value));
    }

    @Test
    public void testSinCos() {
        float step = (float) (TrigMath.TWO_PI / 100.0); //100 steps in the circle
        for (float i = (float) -TrigMath.PI; i < TrigMath.TWO_PI; i += step) {
            testSin(i);
            testCos(i);
        }
    }

    private void assert2D(float angle, Vector2f vector, float x, float y) {
        String msg = "angle=" + angle + " expected [" + x + ", " + y + "] but got [" + vector.getX() + ", " + vector.getY() + "]";
        assertTrue(msg, vector.sub(x, y).lengthSquared() < 0.001);
    }

    private void assert3D(float yaw, float pitch, Vector3f vector, float x, float y, float z) {
        String msg = "[yaw=" + yaw + ", pitch=" + pitch + "] expected [" + x + ", " + y + ", " + z + "] but got [" + vector.getX() + ", " + vector.getY() + ", " + vector.getZ() + "]";
        assertTrue(msg, vector.sub(x, y, z).lengthSquared() < 0.001);
    }

    private void assert2D(double angle, Vector2d vector, double x, double y) {
        String msg = "angle=" + angle + " expected [" + x + ", " + y + "] but got [" + vector.getX() + ", " + vector.getY() + "]";
        assertTrue(msg, vector.sub(x, y).lengthSquared() < 0.00000001);
    }

    private void assert3D(double yaw, double pitch, Vector3d vector, double x, double y, double z) {
        String msg = "[yaw=" + yaw + ", pitch=" + pitch + "] expected [" + x + ", " + y + ", " + z + "] but got [" + vector.getX() + ", " + vector.getY() + ", " + vector.getZ() + "]";
        assertTrue(msg, vector.sub(x, y, z).lengthSquared() < 0.00000001);
    }

    private void test2D(float angle, float x, float y) {
        assert2D(angle, Vector2f.createDirection(angle), x, y);
    }

    private void test3D(float yaw, float pitch, float x, float y, float z) {
        assert3D(yaw, pitch, Vector3f.createDirection(yaw, pitch), x, y, z);
    }

    private void test2D(double angle, double x, double y) {
        assert2D(angle, Vector2d.createDirection(angle), x, y);
    }

    private void test3D(double yaw, double pitch, double x, double y, double z) {
        assert3D(yaw, pitch, Vector3d.createDirection(yaw, pitch), x, y, z);
    }

    @Test
    public void test3DAxis() {
        test3D(0.0f, 0.0f, 1.0f, 0.0f, 0.0f);
        test3D((float) TrigMath.HALF_PI, (float) TrigMath.PI, 0.0f, 0.0f, -1.0f);
        test3D((float) TrigMath.QUARTER_PI, (float) TrigMath.QUARTER_PI, 0.5f, (float) TrigMath.HALF_SQRT_OF_TWO, 0.5f);
        test3D(0.0f, (float) TrigMath.HALF_PI, 0.0f, 1.0f, 0.0f);
        test3D(0.0f, (float) TrigMath.THREE_PI_HALVES, 0.0f, -1.0f, 0.0f);
        // verify that the 2D axis are the same for 3D axis without pitch
        float step = (float) (TrigMath.TWO_PI / 50.0); //50 steps in the circle
        for (float i = (float) -TrigMath.PI; i < TrigMath.TWO_PI; i += step) {
            Vector2f vec2D = Vector2f.createDirection(i);
            Vector3f vec3D = Vector3f.createDirection(i, 0);
            assertEquals(vec2D.getX(), vec3D.getX(), 0.001f);
            assertEquals(vec2D.getY(), vec3D.getZ(), 0.001f);
        }
    }

    @Test
    public void test2DAxis() {
        test2D(0.0f, 1.0f, 0.0f);
        test2D((float) TrigMath.HALF_PI, 0.0f, 1.0f);
        test2D((float) TrigMath.PI, -1.0f, 0.0f);
        test2D((float) TrigMath.THREE_PI_HALVES, 0.0f, -1.0f);
        test2D((float) TrigMath.QUARTER_PI, (float) TrigMath.HALF_SQRT_OF_TWO, (float) TrigMath.HALF_SQRT_OF_TWO);
    }

    @Test
    public void test3DAxisD() {
        test3D(0.0, 0.0, 1.0, 0.0, 0.0);
        test3D(TrigMath.HALF_PI, TrigMath.PI, 0.0, 0.0, -1.0);
        test3D(TrigMath.QUARTER_PI, TrigMath.QUARTER_PI, 0.5f, TrigMath.HALF_SQRT_OF_TWO, 0.5);
        test3D(0.0, TrigMath.HALF_PI, 0.0, 1.0, 0.0);
        test3D(0.0, TrigMath.THREE_PI_HALVES, 0.0, -1.0, 0.0);
        // verify that the 2D axis are the same for 3D axis without pitch
        double step = (TrigMath.TWO_PI / 50.0); // 50 steps in the circle
        for (float i = (float) -TrigMath.PI; i < TrigMath.TWO_PI; i += step) {
            Vector2d vec2D = Vector2d.createDirection(i);
            Vector3d vec3D = Vector3d.createDirection(i, 0);
            assertEquals(vec2D.getX(), vec3D.getX(), 0.001);
            assertEquals(vec2D.getY(), vec3D.getZ(), 0.001);
        }
    }

    @Test
    public void test2DAxisD() {
        test2D(0.0, 1.0, 0.0);
        test2D(TrigMath.HALF_PI, 0.0, 1.0);
        test2D(TrigMath.PI, -1.0, 0.0);
        test2D(TrigMath.THREE_PI_HALVES, 0.0, -1.0);
        test2D(TrigMath.QUARTER_PI, TrigMath.HALF_SQRT_OF_TWO, TrigMath.HALF_SQRT_OF_TWO);
    }

    private void testValue(double value, double result, double realValue) {
        assertTrue("value=" + value + " expected " + realValue + " but got " + result, Math.abs(result - realValue) < 0.0000001);
    }

    private void testAsin(double value) {
        testValue(value, TrigMath.asin(value), Math.asin(value));
    }

    private void testAcos(double value) {
        testValue(value, TrigMath.acos(value), Math.acos(value));
    }

    private void testAsec(double value) {
        testValue(value, TrigMath.asec(value), Math.acos(1 / value));
    }

    private void testAcosec(double value) {
        testValue(value, TrigMath.acsc(value), Math.asin(1 / value));
    }

    private void testAtan(double value) {
        testValue(value, TrigMath.atan(value), Math.atan(value));
    }

    private void testAtan2(double y, double x) {
        double realValue = Math.atan2(y, x);
        double result = TrigMath.atan2(y, x);
        assertTrue("x=" + x + ",y=" + y + " expected " + realValue + " but got " + result, Math.abs(result - realValue) < 0.0000001);
    }

    @Test
    public void testAsinAcos() {
        double step = 2.0 / 100.0;
        for (double i = -1.0; i <= 1.0; i += step) {
            testAsin(i);
            testAcos(i);
        }
    }

    @Test
    public void testAsecAcosec() {
        double step = 4.0 / 100.0;
        for (double i = -2.0; i <= -1; i += step) {
            testAsec(i);
            testAcosec(i);
        }
        for (double i = 1; i <= 2; i += step) {
            testAsec(i);
            testAcosec(i);
        }
    }

    @Test
    public void testAtan() {
        double step = 0.1;
        for (double i = -10.0; i <= 10.0; i += step) {
            testAtan(i);
        }
    }

    @Test
    public void testAtan2() {
        double step = 0.2;
        for (double x = -5.0; x <= 5.0; x += step) {
            for (double y = -5.0; y <= 5.0; y += step) {
                testAtan2(y, x);
            }
        }
    }
}
