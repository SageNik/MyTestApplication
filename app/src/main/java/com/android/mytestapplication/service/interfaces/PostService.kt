package com.android.mytestapplication.service.interfaces

import com.android.mytestapplication.model.Post
import io.realm.RealmResults

/**
 * Service for serve interact with model
 *
 * This is service is used for interact with Post model
 */
interface PostService {

    /**
     * Find Post by id
     * @param id Long : id of post
     * @return found Post if successful or null if not
     */
    fun findPostById(id: Long): Post?

    /**
     * Create or edit Post
     * @param post Post : post entity for create or update
     * @return created or edited post if successful or null if not
     */
    fun createOrEditPost(post: Post): Boolean

    /**
     * Delete Post
     * @param id Long: id of post entity for delete
     * @return "true" if post has been deleted or "false" if not
     */
    fun deletePostById(id: Long): Boolean

    /**
     * Find all Posts from database
     * @return RealmResults<Post>: found list of entities or empty
     */
    fun findAllMyPosts(): RealmResults<Post>
}