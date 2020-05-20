

import com.google.gson.annotations.SerializedName

data class Category(@SerializedName("parent_category_id")
                    val parentCategoryId: String = "",
                    @SerializedName("parent")
                    val parent: Parent,
                    @SerializedName("is_premium")
                    val isPremium: String = "",
                    @SerializedName("name")
                    val name: String = "",
                    @SerializedName("icon")
                    val icon: String = "",
                    @SerializedName("plural_name")
                    val pluralName: String = "",
                    @SerializedName("id")
                    val id: String = "",
                    @SerializedName("custom_data")
                    val customData: String = "")


data class Parent(@SerializedName("name")
                  val name: String = "",
                  @SerializedName("id")
                  val id: String = "")


data class Data(@SerializedName("phone_valid")
                val phoneValid: String = "",
                @SerializedName("email_subscribe")
                val emailSubscribe: String = "",
                @SerializedName("bio")
                val bio: String = "",
                @SerializedName("discount")
                val discount: String = "",
                @SerializedName("type")
                val type: String = "",
                @SerializedName("location_id")
                val locationId: String = "",
                @SerializedName("best_cost_cents")
                val bestCostCents: String = "",
                @SerializedName("score")
                val score: String = "",
                @SerializedName("best_service_detail_id")
                val bestServiceDetailId: String = "",
                @SerializedName("stats")
                val stats: Stats,
                @SerializedName("price")
                val price: String = "",
                @SerializedName("phone_country")
                val phoneCountry: String = "",
                @SerializedName("rank")
                val rank: String = "",
                @SerializedName("id")
                val id: String = "",
                @SerializedName("ratings_count")
                val ratingsCount: String = "",
                @SerializedName("friends_notifications")
                val friendsNotifications: String = "",
                @SerializedName("default_profile_id")
                val defaultProfileId: String = "",
                @SerializedName("has_media")
                val hasMedia: String = "",
                @SerializedName("recommendation_id")
                val recommendationId: String = "",
                @SerializedName("featured_rank")
                val featuredRank: String = "",
                @SerializedName("verified_date")
                val verifiedDate: String = "",
                @SerializedName("completed_at")
                val completedAt: String = "",
                @SerializedName("is_premium")
                val isPremium: String = "",
                @SerializedName("user_id")
                val userId: String = "",
                @SerializedName("phone")
                val phone: String = "",
                @SerializedName("rank_category")
                val rankCategory: String = "",
                @SerializedName("score_updated_at")
                val scoreUpdatedAt: String = "",
                @SerializedName("neighborhood")
                val neighborhood: Neighborhood,
                @SerializedName("services_avg_rating")
                val servicesAvgRating: String = "",
                @SerializedName("country_id")
                val countryId: String = "",
                @SerializedName("city_id")
                val cityId: String = "",
                @SerializedName("gender")
                val gender: String = "",
                @SerializedName("is_hidden")
                val isHidden: String = "",
                @SerializedName("created_at")
                val createdAt: String = "",
                @SerializedName("description")
                val description: String = "",
                @SerializedName("media")
                val media: List<MediaItem>?,
                @SerializedName("min_cost_cents")
                val minCostCents: String = "",
                @SerializedName("claimed_at")
                val claimedAt: String = "",
                @SerializedName("updated_at")
                val updatedAt: String = "",
                @SerializedName("category_id")
                val categoryId: String = "",
                @SerializedName("avg_rating")
                val avgRating: String = "",
                @SerializedName("neighborhood_id")
                val neighborhoodId: String = "",
                @SerializedName("company")
                val company: String = "",
                @SerializedName("is_complete")
                val isComplete: String = "",
                @SerializedName("first_name")
                val firstName: String = "",
                @SerializedName("headline")
                val headline: String = "",
                @SerializedName("email")
                val email: String = "",
                @SerializedName("website")
                val website: String = "",
                @SerializedName("is_visible")
                val isVisible: String = "",
                @SerializedName("is_discount_active")
                val isDiscountActive: String = "",
                @SerializedName("claimed_profile")
                val claimedProfile: String = "",
                @SerializedName("min_cost_sd_id")
                val minCostSdId: String = "",
                @SerializedName("verified")
                val verified: String = "",
                @SerializedName("is_external")
                val isExternal: String = "",
                @SerializedName("last_name")
                val lastName: String = "",
                @SerializedName("rebook_count")
                val rebookCount: String = "",
                @SerializedName("price_unit")
                val priceUnit: String = "",
                @SerializedName("posted_by_user_id")
                val postedByUserId: String = "",
                @SerializedName("services_ratings_count")
                val servicesRatingsCount: String = "",
                @SerializedName("posted_by")
                val postedBy: String = "",
                @SerializedName("min_opt_cost_cents")
                val minOptCostCents: String = "",
                @SerializedName("category")
                val category: Category,
                @SerializedName("is_featured")
                val isFeatured: String = "")


data class ProfileData(@SerializedName("data")
                       val data: Data,
                       @SerializedName("session")
                       val session: Session,
                       @SerializedName("responseTime")
                       val responseTime: String = "",
                       @SerializedName("profile")
                       val profile: Profile,
                       @SerializedName("info")
                       val info: Info)


data class City(@SerializedName("name")
                val name: String = "",
                @SerializedName("id")
                val id: String = "")


data class Info(@SerializedName("code")
                val code: String = "",
                @SerializedName("message")
                val message: String = "")


data class Profile(@SerializedName("phone_valid")
                   val phoneValid: String = "",
                   @SerializedName("email_subscribe")
                   val emailSubscribe: String = "",
                   @SerializedName("bio")
                   val bio: String = "",
                   @SerializedName("discount")
                   val discount: String = "",
                   @SerializedName("type")
                   val type: String = "",
                   @SerializedName("location_id")
                   val locationId: String = "",
                   @SerializedName("best_cost_cents")
                   val bestCostCents: String = "",
                   @SerializedName("abilities")
                   val abilities: List<AbilitiesItem>?,
                   @SerializedName("score")
                   val score: String = "",
                   @SerializedName("best_service_detail_id")
                   val bestServiceDetailId: String = "",
                   @SerializedName("price")
                   val price: String = "",
                   @SerializedName("phone_country")
                   val phoneCountry: String = "",
                   @SerializedName("rank")
                   val rank: String = "",
                   @SerializedName("id")
                   val id: String = "",
                   @SerializedName("ratings_count")
                   val ratingsCount: String = "",
                   @SerializedName("credit")
                   val credit: Credit,
                   @SerializedName("friends_notifications")
                   val friendsNotifications: String = "",
                   @SerializedName("default_profile_id")
                   val defaultProfileId: String = "",
                   @SerializedName("has_media")
                   val hasMedia: String = "",
                   @SerializedName("recommendation_id")
                   val recommendationId: String = "",
                   @SerializedName("invite_link")
                   val inviteLink: String = "",
                   @SerializedName("featured_rank")
                   val featuredRank: String = "",
                   @SerializedName("verified_date")
                   val verifiedDate: String = "",
                   @SerializedName("completed_at")
                   val completedAt: String = "",
                   @SerializedName("is_premium")
                   val isPremium: String = "",
                   @SerializedName("user_id")
                   val userId: String = "",
                   @SerializedName("phone")
                   val phone: String = "",
                   @SerializedName("rank_category")
                   val rankCategory: String = "",
                   @SerializedName("score_updated_at")
                   val scoreUpdatedAt: String = "",
                   @SerializedName("name")
                   val name: String = "",
                   @SerializedName("neighborhood")
                   val neighborhood: Neighborhood,
                   @SerializedName("services_avg_rating")
                   val servicesAvgRating: String = "",
                   @SerializedName("country_id")
                   val countryId: String = "",
                   @SerializedName("city_id")
                   val cityId: String = "",
                   @SerializedName("gender")
                   val gender: String = "",
                   @SerializedName("is_hidden")
                   val isHidden: String = "",
                   @SerializedName("created_at")
                   val createdAt: String = "",
                   @SerializedName("description")
                   val description: String = "",
                   @SerializedName("min_cost_cents")
                   val minCostCents: String = "",
                   @SerializedName("claimed_at")
                   val claimedAt: String = "",
                   @SerializedName("updated_at")
                   val updatedAt: String = "",
                   @SerializedName("category_id")
                   val categoryId: String = "",
                   @SerializedName("avg_rating")
                   val avgRating: String = "",
                   @SerializedName("neighborhood_id")
                   val neighborhoodId: String = "",
                   @SerializedName("company")
                   val company: String = "",
                   @SerializedName("is_complete")
                   val isComplete: String = "",
                   @SerializedName("first_name")
                   val firstName: String = "",
                   @SerializedName("headline")
                   val headline: String = "",
                   @SerializedName("email")
                   val email: String = "",
                   @SerializedName("website")
                   val website: String = "",
                   @SerializedName("is_visible")
                   val isVisible: String = "",
                   @SerializedName("is_discount_active")
                   val isDiscountActive: String = "",
                   @SerializedName("claimed_profile")
                   val claimedProfile: String = "",
                   @SerializedName("min_cost_sd_id")
                   val minCostSdId: String = "",
                   @SerializedName("verified")
                   val verified: String = "",
                   @SerializedName("is_external")
                   val isExternal: String = "",
                   @SerializedName("last_name")
                   val lastName: String = "",
                   @SerializedName("rebook_count")
                   val rebookCount: String = "",
                   @SerializedName("price_unit")
                   val priceUnit: String = "",
                   @SerializedName("posted_by_user_id")
                   val postedByUserId: String = "",
                   @SerializedName("services_ratings_count")
                   val servicesRatingsCount: String = "",
                   @SerializedName("posted_by")
                   val postedBy: String = "",
                   @SerializedName("min_opt_cost_cents")
                   val minOptCostCents: String = "",
                   @SerializedName("category")
                   val category: String = "",
                   @SerializedName("is_featured")
                   val isFeatured: String = "")


data class Neighborhood(@SerializedName("metro_id")
                        val metroId: String = "",
                        @SerializedName("item_type")
                        val itemType: String = "",
                        @SerializedName("borough_id")
                        val boroughId: String = "",
                        @SerializedName("name")
                        val name: String = "",
                        @SerializedName("id")
                        val id: String = "",
                        @SerializedName("borough")
                        val borough: String = "",
                        @SerializedName("enabled")
                        val enabled: String = "")


data class Borough(@SerializedName("metro_id")
                   val metroId: String = "",
                   @SerializedName("city")
                   val city: City,
                   @SerializedName("item_type")
                   val itemType: String = "",
                   @SerializedName("name")
                   val name: String = "",
                   @SerializedName("id")
                   val id: String = "",
                   @SerializedName("enabled")
                   val enabled: String = "")


data class AbilitiesItem(@SerializedName("can")
                         val can: String = "",
                         @SerializedName("updated_at")
                         val updatedAt: String = "",
                         @SerializedName("user_id")
                         val userId: String = "",
                         @SerializedName("profile_id")
                         val profileId: String = "",
                         @SerializedName("name")
                         val name: String = "",
                         @SerializedName("created_at")
                         val createdAt: String = "",
                         @SerializedName("id")
                         val id: String = "")


data class Credit(@SerializedName("transferred")
                  val transferred: String = "",
                  @SerializedName("blocked")
                  val blocked: String = "",
                  @SerializedName("profile_id")
                  val profileId: String = "",
                  @SerializedName("ready")
                  val ready: String = "",
                  @SerializedName("refunded")
                  val refunded: String = "",
                  @SerializedName("used")
                  val used: String = "",
                  @SerializedName("stripe_transferred")
                  val stripeTransferred: String = "",
                  @SerializedName("charged")
                  val charged: String = "")


data class MediaItem(@SerializedName("is_active")
                     val isActive: String = "",
                     @SerializedName("object_type")
                     val objectType: String = "",
                     @SerializedName("bucket_type")
                     val bucketType: String = "",
                     @SerializedName("format")
                     val format: String = "",
                     @SerializedName("caption")
                     val caption: String = "",
                     @SerializedName("source")
                     val source: String = "",
                     @SerializedName("type")
                     val type: String = "",
                     @SerializedName("object_id")
                     val objectId: String = "",
                     @SerializedName("processed")
                     val processed: String = "",
                     @SerializedName("thumbnail_path")
                     val thumbnailPath: String = "",
                     @SerializedName("user_id")
                     val userId: String = "",
                     @SerializedName("media_type")
                     val mediaType: String = "",
                     @SerializedName("profile_id")
                     val profileId: String = "",
                     @SerializedName("raw_image_path")
                     val rawImagePath: String = "",
                     @SerializedName("id")
                     val id: String = "",
                     @SerializedName("position")
                     val position: String = "")


data class Stats(@SerializedName("users_followed")
                 val usersFollowed: String = "",
                 @SerializedName("users_following")
                 val usersFollowing: String = "",
                 @SerializedName("deals_added")
                 val dealsAdded: String = "",
                 @SerializedName("votes_up")
                 val votesUp: String = "",
                 @SerializedName("questions_answered")
                 val questionsAnswered: String = "",
                 @SerializedName("recommendations_received")
                 val recommendationsReceived: String = "",
                 @SerializedName("invites_shared")
                 val invitesShared: String = "",
                 @SerializedName("recommendations")
                 val recommendations: String = "",
                 @SerializedName("recommendations_sent")
                 val recommendationsSent: String = "",
                 @SerializedName("deals_accepted")
                 val dealsAccepted: String = "",
                 @SerializedName("service_details")
                 val serviceDetails: String = "",
                 @SerializedName("shares")
                 val shares: String = "",
                 @SerializedName("sign_up_to_first_booking_time")
                 val signUpToFirstBookingTime: String = "",
                 @SerializedName("votes_down")
                 val votesDown: String = "",
                 @SerializedName("updated_at")
                 val updatedAt: String = "",
                 @SerializedName("page_views")
                 val pageViews: String = "",
                 @SerializedName("recommendations_claimed")
                 val recommendationsClaimed: String = "",
                 @SerializedName("profile_id")
                 val profileId: String = "",
                 @SerializedName("recommendations_unclaimed")
                 val recommendationsUnclaimed: String = "",
                 @SerializedName("id")
                 val id: String = "",
                 @SerializedName("logins")
                 val logins: String = "",
                 @SerializedName("invites_joined")
                 val invitesJoined: String = "",
                 @SerializedName("questions_asked")
                 val questionsAsked: String = "")


data class Session(@SerializedName("adt")
                   val adt: String = "",
                   @SerializedName("user_id")
                   val userId: String = "",
                   @SerializedName("profile_id")
                   val profileId: String = "",
                   @SerializedName("is_live")
                   val isLive: String = "",
                   @SerializedName("id")
                   val id: String = "",
                   @SerializedName("device")
                   val device: String = "")


