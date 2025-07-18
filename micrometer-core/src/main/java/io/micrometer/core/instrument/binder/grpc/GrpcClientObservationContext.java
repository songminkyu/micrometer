/*
 * Copyright 2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.micrometer.core.instrument.binder.grpc;

import io.grpc.Metadata;
import io.grpc.MethodDescriptor.MethodType;
import io.grpc.Status.Code;
import io.micrometer.observation.Observation;
import io.micrometer.observation.transport.Propagator.Setter;
import io.micrometer.observation.transport.RequestReplySenderContext;
import org.jspecify.annotations.Nullable;

/**
 * {@link Observation.Context} for gRPC client.
 *
 * @author Tadaya Tsuyukubo
 * @since 1.10.0
 */
public class GrpcClientObservationContext extends RequestReplySenderContext<Metadata, Object> {

    private @Nullable String serviceName;

    private @Nullable String methodName;

    @SuppressWarnings("NullAway.Init")
    private String fullMethodName;

    @SuppressWarnings("NullAway.Init")
    private MethodType methodType;

    private @Nullable Code statusCode;

    @SuppressWarnings("NullAway.Init")
    private String authority;

    private @Nullable Metadata headers;

    private @Nullable Metadata trailers;

    @SuppressWarnings("NullAway.Init")
    private String peerName;

    private @Nullable Integer peerPort;

    public GrpcClientObservationContext(Setter<Metadata> setter) {
        super(setter);
    }

    public @Nullable String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public @Nullable String getMethodName() {
        return this.methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getFullMethodName() {
        return this.fullMethodName;
    }

    public void setFullMethodName(String fullMethodName) {
        this.fullMethodName = fullMethodName;
    }

    public MethodType getMethodType() {
        return this.methodType;
    }

    public void setMethodType(MethodType methodType) {
        this.methodType = methodType;
    }

    public @Nullable Code getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(Code statusCode) {
        this.statusCode = statusCode;
    }

    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    /**
     * Response headers.
     * @return response headers
     * @since 1.13.0
     */
    public @Nullable Metadata getHeaders() {
        return this.headers;
    }

    /**
     * Set response headers.
     * @param headers response headers
     * @since 1.13.0
     */
    public void setHeaders(Metadata headers) {
        this.headers = headers;
    }

    /**
     * Trailers.
     * @return trailers
     * @since 1.13.0
     */
    public @Nullable Metadata getTrailers() {
        return this.trailers;
    }

    /**
     * Set trailers.
     * @param trailers
     * @since 1.13.0
     */
    public void setTrailers(Metadata trailers) {
        this.trailers = trailers;
    }

    public String getPeerName() {
        return this.peerName;
    }

    public void setPeerName(String peerName) {
        this.peerName = peerName;
    }

    public @Nullable Integer getPeerPort() {
        return this.peerPort;
    }

    public void setPeerPort(@Nullable Integer peerPort) {
        this.peerPort = peerPort;
    }

}
