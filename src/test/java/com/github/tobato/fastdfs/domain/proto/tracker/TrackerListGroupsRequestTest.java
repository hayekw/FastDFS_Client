package com.github.tobato.fastdfs.domain.proto.tracker;

import com.github.tobato.fastdfs.TestConstants;
import com.github.tobato.fastdfs.domain.proto.tracker.internal.TrackerListGroupsRequest;
import org.junit.Test;

import java.util.stream.IntStream;

/**
 * 列举Groups请求
 * 
 * @author tobato
 *
 */
public class TrackerListGroupsRequestTest {

    @Test
    public void testGetByteContent() {
        TrackerListGroupsRequest request = new TrackerListGroupsRequest();
        printRequest(request.getHeadByte(TestConstants.DEFAULT_CHARSET));
    }

    private void printRequest(byte[] request) {
        IntStream.range(0, request.length).forEach(i -> {
            System.out.print(request[i]);
            System.out.print(" ");
        });
    }

}
