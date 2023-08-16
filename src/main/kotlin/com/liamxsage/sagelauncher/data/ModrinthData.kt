package com.liamxsage.sagelauncher.data

data class Project(
    val additional_categories: List<Any>,
    val approved: String,
    val body: String,
    val body_url: Any,
    val categories: List<String>,
    val client_side: String,
    val color: Int,
    val description: String,
    val discord_url: Any,
    val donation_urls: List<Any>,
    val downloads: Int,
    val followers: Int,
    val gallery: List<Gallery>,
    val game_versions: List<String>,
    val icon_url: String,
    val id: String,
    val issues_url: String,
    val license: License,
    val loaders: List<String>,
    val moderator_message: Any,
    val monetization_status: String,
    val project_type: String,
    val published: String,
    val queued: Any,
    val requested_status: Any,
    val server_side: String,
    val slug: String,
    val source_url: String,
    val status: String,
    val team: String,
    val thread_id: String,
    val title: String,
    val updated: String,
    val versions: List<String>,
    val wiki_url: Any
)

data class Gallery(
    val created: String,
    val description: Any,
    val featured: Boolean,
    val ordering: Int,
    val title: String,
    val url: String
)

data class License(
    val id: String,
    val name: String,
    val url: Any
)

class Versions : ArrayList<VersionsItem>()

data class VersionsItem(
    val author_id: String,
    val changelog: String,
    val changelog_url: Any,
    val date_published: String,
    val dependencies: List<Dependency>,
    val downloads: Int,
    val featured: Boolean,
    val files: List<File>,
    val game_versions: List<String>,
    val id: String,
    val loaders: List<String>,
    val name: String,
    val project_id: String,
    val requested_status: Any,
    val status: String,
    val version_number: String,
    val version_type: String
)

data class Dependency(
    val dependency_type: String,
    val file_name: Any,
    val project_id: String,
    val version_id: String
)

data class File(
    val file_type: Any,
    val filename: String,
    val hashes: Hashes,
    val primary: Boolean,
    val size: Int,
    val url: String
)

data class Hashes(
    val sha1: String,
    val sha512: String
)

class ProjectMembers : ArrayList<ProjectMembersItem>()

data class ProjectMembersItem(
    val accepted: Boolean,
    val ordering: Int,
    val payouts_split: Any,
    val permissions: Any,
    val role: String,
    val team_id: String,
    val user: User
)

data class User(
    val auth_providers: Any,
    val avatar_url: String,
    val badges: Int,
    val bio: String,
    val created: String,
    val email: Any,
    val email_verified: Any,
    val github_id: Any,
    val has_password: Any,
    val has_totp: Any,
    val id: String,
    val name: String,
    val payout_data: Any,
    val role: String,
    val username: String
)