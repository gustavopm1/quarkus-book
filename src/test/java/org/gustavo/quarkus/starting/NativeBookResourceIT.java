package org.gustavo.quarkus.starting;

import io.quarkus.test.junit.QuarkusIntegrationTest;

@QuarkusIntegrationTest
class NativeBookResourceIT extends BookResourceTest {
    // Execute the same tests but in packaged mode.
}
