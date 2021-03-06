/*
 * Copyright 2018. M. Reza Nasirloo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mrezanasirloo.slick.middleware;

import com.google.testing.compile.JavaFileObjects;
import com.google.testing.compile.JavaSourcesSubjectFactory;

import org.junit.Test;

import java.util.Arrays;

import javax.tools.JavaFileObject;

import static com.google.common.truth.Truth.assertAbout;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MiddlewareTest {
    @Test
    public void requestGeneric() {
        JavaFileObject routerSource = JavaFileObjects.forResource("resources/RouterGeneric.java");
        JavaFileObject genSource = JavaFileObjects.forResource("resources/RouterGenericSlick.java");
        JavaFileObject middlewareSource = JavaFileObjects.forResource("resources/MiddlewareNoOp.java");
        JavaFileObject middlewareSource2 = JavaFileObjects.forResource("resources/MiddlewareNoOp2.java");

        assertAbout(JavaSourcesSubjectFactory.javaSources())
                .that(Arrays.asList(routerSource, middlewareSource, middlewareSource2))
                .processedWith(new MiddlewareProcessor())
                .compilesWithoutError()
                .and()
                .generatesSources(genSource);
    }

    @Test
    public void requestSimple() {
        JavaFileObject routerSource = JavaFileObjects.forResource("resources/RouterSimple.java");
        JavaFileObject genSource = JavaFileObjects.forResource("resources/RouterSimpleSlick.java");
        JavaFileObject middlewareSource = JavaFileObjects.forResource("resources/MiddlewareNoOp.java");
        JavaFileObject middlewareSource2 = JavaFileObjects.forResource("resources/MiddlewareNoOp2.java");

        assertAbout(JavaSourcesSubjectFactory.javaSources())
                .that(Arrays.asList(routerSource, middlewareSource, middlewareSource2))
                .processedWith(new MiddlewareProcessor())
                .compilesWithoutError()
                .and()
                .generatesSources(genSource);
    }

    @Test
    public void requestRx() {
        JavaFileObject routerSource = JavaFileObjects.forResource("resources/RouterRx.java");
        JavaFileObject genSource = JavaFileObjects.forResource("resources/RouterRxSlick.java");
        JavaFileObject middlewareSource = JavaFileObjects.forResource("resources/MiddlewareNoOp.java");
        JavaFileObject middlewareSource2 = JavaFileObjects.forResource("resources/MiddlewareNoOp2.java");

        assertAbout(JavaSourcesSubjectFactory.javaSources())
                .that(Arrays.asList(routerSource, middlewareSource, middlewareSource2))
                .processedWith(new MiddlewareProcessor())
                .compilesWithoutError()
                .and()
                .generatesSources(genSource);
    }

    @Test
    public void requestCompletable() {
        JavaFileObject routerSource = JavaFileObjects.forResource("resources/RouterCompletable.java");
        JavaFileObject genSource = JavaFileObjects.forResource("resources/RouterCompletableSlick.java");
        JavaFileObject middlewareSource = JavaFileObjects.forResource("resources/MiddlewareNoOp.java");
        JavaFileObject middlewareSource2 = JavaFileObjects.forResource("resources/MiddlewareNoOp2.java");

        assertAbout(JavaSourcesSubjectFactory.javaSources())
                .that(Arrays.asList(routerSource, middlewareSource, middlewareSource2))
                .processedWith(new MiddlewareProcessor())
                .compilesWithoutError()
                .and()
                .generatesSources(genSource);
    }

    @Test
    public void middlewareDagger() {
        JavaFileObject routerSource = JavaFileObjects.forResource("resources/RouterDagger.java");
        JavaFileObject genSource = JavaFileObjects.forResource("resources/RouterDaggerSlick.java");
        JavaFileObject middlewareSource = JavaFileObjects.forResource("resources/MiddlewareNoOp.java");

        assertAbout(JavaSourcesSubjectFactory.javaSources())
                .that(Arrays.asList(routerSource, middlewareSource))
                .processedWith(new MiddlewareProcessor())
                .compilesWithoutError()
                .and()
                .generatesSources(genSource);
    }

}