package com.boot.spring.jpa.h2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;


@Data
public class GithubRepository {
	
	 @SerializedName("id")
	    @Expose
	    private Integer id;
	    @SerializedName("node_id")
	    @Expose
	    private String nodeId;
	    @SerializedName("name")
	    @Expose
	    private String name;
	    @SerializedName("full_name")
	    @Expose
	    private String fullName;
	    @SerializedName("owner")
	    @Expose
	    private Owner owner;
	    @SerializedName("private")
	    @Expose
	    private Boolean _private;
	    @SerializedName("html_url")
	    @Expose
	    private String htmlUrl;
	    @SerializedName("description")
	    @Expose
	    private Object description;
	    @SerializedName("fork")
	    @Expose
	    private Boolean fork;
	    @SerializedName("url")
	    @Expose
	    private String url;
	    @SerializedName("forks_url")
	    @Expose
	    private String forksUrl;
	    @SerializedName("keys_url")
	    @Expose
	    private String keysUrl;
	    @SerializedName("collaborators_url")
	    @Expose
	    private String collaboratorsUrl;
	    @SerializedName("teams_url")
	    @Expose
	    private String teamsUrl;
	    @SerializedName("hooks_url")
	    @Expose
	    private String hooksUrl;
	    @SerializedName("issue_events_url")
	    @Expose
	    private String issueEventsUrl;
	    @SerializedName("events_url")
	    @Expose
	    private String eventsUrl;
	    @SerializedName("assignees_url")
	    @Expose
	    private String assigneesUrl;
	    @SerializedName("branches_url")
	    @Expose
	    private String branchesUrl;
	    @SerializedName("tags_url")
	    @Expose
	    private String tagsUrl;
	    @SerializedName("blobs_url")
	    @Expose
	    private String blobsUrl;
	    @SerializedName("git_tags_url")
	    @Expose
	    private String gitTagsUrl;
	    @SerializedName("git_refs_url")
	    @Expose
	    private String gitRefsUrl;
	    @SerializedName("trees_url")
	    @Expose
	    private String treesUrl;
	    @SerializedName("statuses_url")
	    @Expose
	    private String statusesUrl;
	    @SerializedName("languages_url")
	    @Expose
	    private String languagesUrl;
	    @SerializedName("stargazers_url")
	    @Expose
	    private String stargazersUrl;
	    @SerializedName("contributors_url")
	    @Expose
	    private String contributorsUrl;
	    @SerializedName("subscribers_url")
	    @Expose
	    private String subscribersUrl;
	    @SerializedName("subscription_url")
	    @Expose
	    private String subscriptionUrl;
	    @SerializedName("commits_url")
	    @Expose
	    private String commitsUrl;
	    @SerializedName("git_commits_url")
	    @Expose
	    private String gitCommitsUrl;
	    @SerializedName("comments_url")
	    @Expose
	    private String commentsUrl;
	    @SerializedName("issue_comment_url")
	    @Expose
	    private String issueCommentUrl;
	    @SerializedName("contents_url")
	    @Expose
	    private String contentsUrl;
	    @SerializedName("compare_url")
	    @Expose
	    private String compareUrl;
	    @SerializedName("merges_url")
	    @Expose
	    private String mergesUrl;
	    @SerializedName("archive_url")
	    @Expose
	    private String archiveUrl;
	    @SerializedName("downloads_url")
	    @Expose
	    private String downloadsUrl;
	    @SerializedName("issues_url")
	    @Expose
	    private String issuesUrl;
	    @SerializedName("pulls_url")
	    @Expose
	    private String pullsUrl;
	    @SerializedName("milestones_url")
	    @Expose
	    private String milestonesUrl;
	    @SerializedName("notifications_url")
	    @Expose
	    private String notificationsUrl;
	    @SerializedName("labels_url")
	    @Expose
	    private String labelsUrl;
	    @SerializedName("releases_url")
	    @Expose
	    private String releasesUrl;
	    @SerializedName("deployments_url")
	    @Expose
	    private String deploymentsUrl;
	    @SerializedName("created_at")
	    @Expose
	    private String createdAt;
	    @SerializedName("updated_at")
	    @Expose
	    private String updatedAt;
	    @SerializedName("pushed_at")
	    @Expose
	    private String pushedAt;
	    @SerializedName("git_url")
	    @Expose
	    private String gitUrl;
	    @SerializedName("ssh_url")
	    @Expose
	    private String sshUrl;
	    @SerializedName("clone_url")
	    @Expose
	    private String cloneUrl;
	    @SerializedName("svn_url")
	    @Expose
	    private String svnUrl;
	    @SerializedName("homepage")
	    @Expose
	    private Object homepage;
	    @SerializedName("size")
	    @Expose
	    private Integer size;
	    @SerializedName("stargazers_count")
	    @Expose
	    private Integer stargazersCount;
	    @SerializedName("watchers_count")
	    @Expose
	    private Integer watchersCount;
	    @SerializedName("language")
	    @Expose
	    private String language;
	    @SerializedName("has_issues")
	    @Expose
	    private Boolean hasIssues;
	    @SerializedName("has_projects")
	    @Expose
	    private Boolean hasProjects;
	    @SerializedName("has_downloads")
	    @Expose
	    private Boolean hasDownloads;
	    @SerializedName("has_wiki")
	    @Expose
	    private Boolean hasWiki;
	    @SerializedName("has_pages")
	    @Expose
	    private Boolean hasPages;
	    @SerializedName("forks_count")
	    @Expose
	    private Integer forksCount;
	    @SerializedName("mirror_url")
	    @Expose
	    private Object mirrorUrl;
	    @SerializedName("archived")
	    @Expose
	    private Boolean archived;
	    @SerializedName("open_issues_count")
	    @Expose
	    private Integer openIssuesCount;
	    @SerializedName("license")
	    @Expose
	    private Object license;
	    @SerializedName("forks")
	    @Expose
	    private Integer forks;
	    @SerializedName("open_issues")
	    @Expose
	    private Integer openIssues;
	    @SerializedName("watchers")
	    @Expose
	    private Integer watchers;
	    @SerializedName("default_branch")
	    @Expose
	    private String defaultBranch;
	    @SerializedName("permissions")
	    @Expose
	    private Permissions permissions;

}
