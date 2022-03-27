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
package org.cloudburstmc.math.imaginary;

import java.util.Iterator;
import java.util.ServiceLoader;

class Imaginary {
    private static final ServiceLoader<ImaginaryProvider> IMAGINARY_PROVIDER_LOADER = ServiceLoader.load(ImaginaryProvider.class);
    private static ImaginaryProvider cached;

    public static ImaginaryProvider provider() {
        if (cached != null) {
            return cached;
        }

        Iterator<ImaginaryProvider> iterator = IMAGINARY_PROVIDER_LOADER.iterator();
        if (!iterator.hasNext()) {
            throw new RuntimeException("Could not initialize imaginary provider as no implementation was provided!");
        }

        return cached = iterator.next();
    }

    public static Complexd createComplexd(double x, double y) {
        return provider().createComplexd(x, y);
    }

    public static Complexf createComplexf(float x, float y) {
        return provider().createComplexf(x, y);
    }

    public static Quaterniond createQuaterniond(double x, double y, double z, double w) {
        return provider().createQuaterniond(x, y, z, w);
    }

    public static Quaternionf createQuaternionf(float x, float y, float z, float w) {
        return provider().createQuaternionf(x, y, z, w);
    }
}
