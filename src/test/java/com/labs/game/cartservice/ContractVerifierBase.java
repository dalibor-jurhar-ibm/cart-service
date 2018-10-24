package com.labs.game.cartservice;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = MOCK)
@DirtiesContext
@AutoConfigureMessageVerifier
public abstract class ContractVerifierBase {

	@Autowired
	private CartController controller;

	@Before
	public void setUp() {
		StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(controller);
		RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
	}
}