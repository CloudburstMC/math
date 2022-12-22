/*
 * This file is part of Flow Math, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2013 Flow Powered <https://flowpowered.com/>
 * Copyright (c) 2013 CloudburstMC <https://cloudburstmc.org/>
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
package org.cloudburstmc.math.vector;

import org.cloudburstmc.math.MathImplementationLoader;

import java.util.Iterator;

class Vectors {
    private static VectorProvider cached;
    
    public static VectorProvider provider() {
        if (cached != null) {
            return cached;
        }
    
        Iterator<VectorProvider> iterator = MathImplementationLoader.serviceLoader(VectorProvider.class).iterator();
        if (!iterator.hasNext()) {
            throw new RuntimeException("Could not initialize vector provider as no implementation was provided!");
        }
    
        return cached = iterator.next();
    }
    
    public static Vector2d createVector2d(double x, double y) {
        return provider().createVector2d(x, y);
    }
    
    public static Vector2f createVector2f(float x, float y) {
        return provider().createVector2f(x, y);
    }
    
    public static Vector2i createVector2i(int x, int y) {
        return provider().createVector2i(x, y);
    }
    
    public static Vector2l createVector2l(long x, long y) {
        return provider().createVector2l(x, y);
    }
    
    public static Vector3d createVector3d(double x, double y, double z) {
        return provider().createVector3d(x, y, z);
    }
    
    public static Vector3f createVector3f(float x, float y, float z) {
        return provider().createVector3f(x, y, z);
    }
    
    public static Vector3i createVector3i(int x, int y, int z) {
        return provider().createVector3i(x, y, z);
    }
    
    public static Vector3l createVector3l(long x, long y, long z) {
        return provider().createVector3l(x, y, z);
    }
    
    public static Vector4d createVector4d(double x, double y, double z, double w) {
        return provider().createVector4d(x, y, z, w);
    }
    
    public static Vector4f createVector4f(float x, float y, float z, float w) {
        return provider().createVector4f(x, y, z, w);
    }
    
    public static Vector4i createVector4i(int x, int y, int z, int w) {
        return provider().createVector4i(x, y, z, w);
    }
    
    public static Vector4l createVector4l(long x, long y, long z, long w) {
        return provider().createVector4l(x, y, z, w);
    }
}