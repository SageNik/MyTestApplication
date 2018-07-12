package com.android.mytestapplication.repository.interfaces

import com.android.mytestapplication.model.Post
import io.realm.RealmResults
import org.json.JSONArray
import java.net.URL

/**
 * Repository for interact with database
 *
 * This is repository is used to execute Post model queries
 */
interface PostRepository {

    /**
     * Find Post from database by id
     * @param id Long : id of post
     * @return found Post if successful or null if not
     */
    fun findOneById(id: Long): Post?

    /**
     * Save Post in database
     * @param post Post : post entity for save
     * @return saved post if successful or null if not
     */
    fun save(post: Post): Post?

    /**
     * Update Post in database
     * @param post Post : post entity for update
     * @return updated post if successful or null if not
     */
    fun update(post: Post): Post?

    /**
     * Delete Post from database
     * @param post Post : post entity for delete
     */
    fun delete(post: Post)

    /**
     * Find all Posts from database
     * @return RealmResults<Post>: found list of entities or empty
     */
    fun findAllMyPosts(): RealmResults<Post>

}