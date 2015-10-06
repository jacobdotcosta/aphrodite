/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2015, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.set.aphrodite.domain;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Represents an issue in a issue tracker (bugzilla, jira...)
 *
 * @author egonzalez
 */
public class Issue {

    private URL url;

    // The unique id of an issue within its issue tracker domain e.g WFLY-5048
    private String trackerId;

    private String product; // E.g EAP6

    private String component; // E.g Clustering

    private String description;

    private String assignee;

    private Stage stage;

    private IssueStatus status;

    private IssueType type;

    private Release release;

    private Map<Stream,FlagStatus> streams;

    private List<URL> dependsOn;

    private List<URL> blocks;

    private IssueEstimation estimation;

    private List<Comment> comments;

    public Issue(URL url) {
        if (url == null)
            throw new IllegalArgumentException("Issue URL cannot be null");

        this.url = url;
        this.stage = new Stage();
        this.status = IssueStatus.UNDEFINED;
        this.type = IssueType.UNDEFINED;
        this.release = new Release();
        this.streams = new HashMap<>();
        this.dependsOn = new ArrayList<>();
        this.blocks = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public URL getURL() {
        return url;
    }

    public Optional<String> getTrackerId() {
        return Optional.ofNullable(trackerId);
    }

    public void setTrackerId(String trackerId) {
        this.trackerId = trackerId;
    }

    public Optional<String> getProduct() {
        return Optional.ofNullable(product);
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Optional<String> getComponent() {
        return Optional.ofNullable(component);
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Optional<String> getAssignee() {
        return Optional.ofNullable(assignee);
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public IssueStatus getStatus() {
        return status;
    }

    public void setStatus(IssueStatus status) {
        this.status = status;
    }

    public IssueType getType() {
        return type;
    }

    public void setType(IssueType type) {
        this.type = type;
    }

    public Release getRelease() {
        return release;
    }

    public void setRelease(Release release) {
        this.release = release;
    }

    public Map<Stream, FlagStatus> getStreams() {
        return streams;
    }

    public void setStreams(Map<Stream, FlagStatus> streams) {
        this.streams = streams;
    }

    public List<URL> getDependsOn() {
        return dependsOn;
    }

    public void setDependsOn(List<URL> dependsOn) {
        this.dependsOn = dependsOn;
    }

    public List<URL> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<URL> blocks) {
        this.blocks = blocks;
    }

    public Optional<IssueEstimation> getEstimation() {
        return Optional.ofNullable(estimation);
    }

    public void setEstimation(IssueEstimation estimation) {
        this.estimation = estimation;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "url=" + url +
                ", trackerId='" + trackerId + '\'' +
                ", product='" + product + '\'' +
                ", component='" + component + '\'' +
                ", description='" + getPrintableDescription() + '\'' +
                ", assignee='" + assignee + '\'' +
                ", stage=" + stage +
                ", status=" + status +
                ", type=" + type +
                ", release=" + release +
                ", streams=" + streams +
                ", dependsOn=" + dependsOn +
                ", blocks=" + blocks +
                ", estimation=" + estimation +
                ", #comments=" + comments.size() +
                "}\n";
    }

    private String getPrintableDescription() {
        if (description.length() < 10)
            return description + "... ";
        return description.substring(0, 10) + "... ";
    }
}
