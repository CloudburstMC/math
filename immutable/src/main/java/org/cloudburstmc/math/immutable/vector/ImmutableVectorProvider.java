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
package org.cloudburstmc.math.immutable.vector;

import org.cloudburstmc.math.vector.Vector2d;
import org.cloudburstmc.math.vector.Vector2f;
import org.cloudburstmc.math.vector.Vector2i;
import org.cloudburstmc.math.vector.Vector2l;
import org.cloudburstmc.math.vector.Vector3d;
import org.cloudburstmc.math.vector.Vector3f;
import org.cloudburstmc.math.vector.Vector3i;
import org.cloudburstmc.math.vector.Vector3l;
import org.cloudburstmc.math.vector.Vector4d;
import org.cloudburstmc.math.vector.Vector4f;
import org.cloudburstmc.math.vector.Vector4i;
import org.cloudburstmc.math.vector.Vector4l;
import org.cloudburstmc.math.vector.VectorProvider;

public class ImmutableVectorProvider implements VectorProvider {

    @Override
    public Vector2d createVector2d(double x, double y) {
        return new ImmutableVector2d(x, y);
    }

    @Override
    public Vector2f createVector2f(float x, float y) {
        return new ImmutableVector2f(x, y);
    }

    @Override
    public Vector2i createVector2i(int x, int y) {
        return new ImmutableVector2i(x, y);
    }

    @Override
    public Vector2l createVector2l(long x, long y) {
        return new ImmutableVector2l(x, y);
    }

    @Override
    public Vector3d createVector3d(double x, double y, double z) {
        return new ImmutableVector3d(x, y, z);
    }

    @Override
    public Vector3f createVector3f(float x, float y, float z) {
        return new ImmutableVector3f(x, y, z);
    }

    @Override
    public Vector3i createVector3i(int x, int y, int z) {
        return new ImmutableVector3i(x, y, z);
    }

    @Override
    public Vector3l createVector3l(long x, long y, long z) {
        return new ImmutableVector3l(x, y, z);
    }

    @Override
    public Vector4d createVector4d(double x, double y, double z, double w) {
        return new ImmutableVector4d(x, y, z, w);
    }

    @Override
    public Vector4f createVector4f(float x, float y, float z, float w) {
        return new ImmutableVector4f(x, y, z, w);
    }

    @Override
    public Vector4i createVector4i(int x, int y, int z, int w) {
        return new ImmutableVector4i(x, y, z, w);
    }

    @Override
    public Vector4l createVector4l(long x, long y, long z, long w) {
        return new ImmutableVector4l(x, y, z, w);
    }
}
