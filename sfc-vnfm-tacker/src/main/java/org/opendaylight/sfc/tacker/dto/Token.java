/*
 * Copyright (c) 2016 Cisco Systems, Inc. and others. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.sfc.tacker.dto;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Token {

    @SerializedName("issued_at")
    private Date issuedAt;
    private Date expires;
    private String id;
    private Tenant tenant;

    @SerializedName("audit_ids")
    private String[] auditIds;

    // used by GSON
    private Token() {}

    private Token(TokenBuilder builder) {
        this.issuedAt = builder.getIssuedAt();
        this.expires = builder.getExpires();
        this.id = builder.getId();
        this.tenant = builder.getTenant();
        this.auditIds = builder.getAuditIds();
    }

    public static TokenBuilder builder() {
        return new TokenBuilder();
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public Date getExpires() {
        return expires;
    }

    public String getId() {
        return id;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public String[] getAuditIds() {
        return auditIds;
    }

    public static class TokenBuilder {

        private Date issuedAt;
        private Date expires;
        private String id;
        private Tenant tenant;
        private String[] auditIds;

        public Date getIssuedAt() {
            return issuedAt;
        }

        public TokenBuilder setIssuedAt(Date issuedAt) {
            this.issuedAt = issuedAt;
            return this;
        }

        public Date getExpires() {
            return expires;
        }

        public TokenBuilder setExpires(Date expires) {
            this.expires = expires;
            return this;
        }

        public String getId() {
            return id;
        }

        public TokenBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public Tenant getTenant() {
            return tenant;
        }

        public TokenBuilder setTenant(Tenant tenant) {
            this.tenant = tenant;
            return this;
        }

        public String[] getAuditIds() {
            return auditIds;
        }

        public TokenBuilder setAuditIds(String[] auditIds) {
            this.auditIds = auditIds;
            return this;
        }

        public Token build() {
            return new Token(this);
        }
    }
}
