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

import java.util.Iterator;
import java.util.ServiceLoader;

public interface VectorProvider {

    Vector2d createVector2d(double x, double y);

    Vector2f createVector2f(float x, float y);

    Vector2i createVector2i(int x, int y);

    Vector2l createVector2l(long x, long y);

    Vector3d createVector3d(double x, double y, double z);

    Vector3f createVector3f(float x, float y, float z);

    Vector3i createVector3i(int x, int y, int z);

    Vector3l createVector3l(long x, long y, long z);

    Vector4d createVector4d(double x, double y, double z, double w);

    Vector4f createVector4f(float x, float y, float z, float w);

    Vector4i createVector4i(int x, int y, int z, int w);

    Vector4l createVector4l(long x, long y, long z, long w);

}
