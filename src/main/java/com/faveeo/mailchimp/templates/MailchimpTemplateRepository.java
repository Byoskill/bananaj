package com.faveeo.mailchimp.templates;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * The type Mailchimp template repository.
 */
@JsonIgnoreProperties
public class MailchimpTemplateRepository {

    private static final Logger log = LoggerFactory.getLogger(MailchimpTemplateRepository.class);
    private final ObjectMapper objectMapper;
    private MailchimpTemplateClient mailchimpTemplateClient;

    /**
     * Instantiates a new Mailchimp template repository.
     *
     * @param mailchimpTemplateClient the mailchimp template client
     */
    public MailchimpTemplateRepository(final MailchimpTemplateClient mailchimpTemplateClient) {
        this.mailchimpTemplateClient = mailchimpTemplateClient;
        objectMapper = initObjectMapper();
    }

    /**
     * Init object mapper object mapper.
     *
     * @return the object mapper
     */
    public static ObjectMapper initObjectMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JodaModule());
        final SimpleModule simpleModule = new SimpleModule();
        objectMapper.registerModule(simpleModule);
        return objectMapper;
    }

    public List<MailchimpTemplate> getTemplates(final int offset, final int count) throws IOException {

        final Call<JsonNode> templates = mailchimpTemplateClient.getTemplates(count, offset);
        final Response<JsonNode> execute;
        execute = templates.execute();

        final JsonNode body = execute.body();
        if (body == null) return Collections.emptyList();

        final MailchimpTemplates mailchimpTemplates = objectMapper.treeToValue(body, MailchimpTemplates.class);

        return mailchimpTemplates.templates;
    }

    /**
     * Gets template.
     *
     * @param id the id
     * @return the template
     * @throws IOException the io exception
     */
    public Optional<MailchimpTemplateDetails> getTemplate(final Integer id) throws IOException {
        final Call<JsonNode> templateCall = mailchimpTemplateClient.getTemplate(id);
        final Response<JsonNode> jsonNodeResponse = templateCall.execute();
        final JsonNode body = jsonNodeResponse.body();
        if (body == null) return Optional.empty();
        return Optional.ofNullable(objectMapper.treeToValue(body, MailchimpTemplateDetails.class));
    }

    /**
     * Gets template default content.
     *
     * @param id the id
     * @return the template default content
     * @throws IOException the io exception
     */
    public JsonNode getTemplateDefaultContent(final Integer id) throws IOException {
        final Response<JsonNode> execute = mailchimpTemplateClient.getTemplateDefaultContent(id).execute();
        return execute.body();
    }
}
