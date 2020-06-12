package com.raphael.api.ApiSybase.error;

import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;

public class ResourceNotFoundDetails {
    private String titulo;
    private int status;
    private String detalhe;
    private String timestamp;
    private String mensagem;

    private ResourceNotFoundDetails() {
    }


    public String getTitulo() {
        return titulo;
    }

    public int getStatus() {
        return status;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getMensagem() {
        return mensagem;
    }

    public static final class Builder {
        private String titulo;
        private int status;
        private String detalhe;
        private String timestamp;
        private String mensagem;

        private Builder() {
        }

        public static Builder newBuiler() {
            return new Builder();
        }

        public Builder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder detalhe(String detalhe) {
            this.detalhe = detalhe;
            return this;
        }

        public Builder timestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder mensagem(String mensagem) {
            this.mensagem = mensagem;
            return this;
        }

        public ResourceNotFoundDetails build() {
            ResourceNotFoundDetails resourceNotFoundDetails = new ResourceNotFoundDetails();
            resourceNotFoundDetails.mensagem = this.mensagem;
            resourceNotFoundDetails.timestamp = this.timestamp;
            resourceNotFoundDetails.status = this.status;
            resourceNotFoundDetails.detalhe = this.detalhe;
            resourceNotFoundDetails.titulo = this.titulo;
            return resourceNotFoundDetails;
        }
    }
}
