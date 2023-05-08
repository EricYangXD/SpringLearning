package learning.spring.helloworld;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.jetbrains.annotations.NotNull;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.Assert.*;

@SpringBootTest
class ApplicationTests {
	MockWebServer server;

	@BeforeEach
	void initMockServer() throws IOException {
		server = new MockWebServer();
		server.setDispatcher(dispatcher());
		server.start(32800);
	}

	@AfterEach
	void closeMockServer() throws IOException {
		server.close();
	}

	@Test
	void testGet() throws IOException {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(server.url("")).build();
		Response response = client.newCall(request).execute();
		Assertions.assertNotNull(response.body());
		String body = response.body().string();
		Assertions.assertTrue(containsExpectedJson(body));
	}

	private Dispatcher dispatcher() {
		return new Dispatcher() {
			@NotNull
			@Override
			public MockResponse dispatch(@NotNull RecordedRequest request) {
				return new MockResponse().setResponseCode(200)
						.setBody("{\"id\":4234,\"domain\":\"itcore\"}");
			}
		};
	}

	private boolean containsExpectedJson(String body) {
		return body.contains("{\"id\":4234,\"domain\":\"itcore\"}");
	}
}
