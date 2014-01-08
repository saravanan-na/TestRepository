/**
 * Archetype - phresco-java-quickstart-archetype
 *
 * Copyright (C) 1999-2013 Photon Infotech Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.photon.phresco.testcases;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.swing.edt.GuiActionRunner.execute;

import org.fest.swing.annotation.RunsInEDT;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.junit.testcase.FestSwingJUnitTestCase;
import org.junit.Test;

import com.photon.phresco.HelloWorld;

public class SampleHelloWorld extends FestSwingJUnitTestCase {

	private FrameFixture phresco;

	protected void onSetUp() {
		phresco = new FrameFixture(robot(), createNewEditor());
		phresco.show();
		phresco.maximize();
		System.out.println("**************Executed onsetup**************");
	}

	@RunsInEDT
	private static HelloWorld createNewEditor() {
		return execute(new GuiQuery<HelloWorld>() {
			protected HelloWorld executeInEDT() throws Throwable {
				return new HelloWorld();
			}
		});
	}

	@Test
	public void testHelloWorld() throws InterruptedException {
		Thread.sleep(5000);
		assertThat(phresco.label().text()).contains("Hello World");

	}
}