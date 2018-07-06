
package com.android.mytestapplication.service.impl

import com.android.mytestapplication.model.Post
import com.android.mytestapplication.repository.impl.RealmPostRepositoryImpl
import com.android.mytestapplication.repository.interfaces.PostRepository
import com.android.mytestapplication.service.interfaces.PostService
import io.realm.RealmResults

class PostServiceImpl: PostService {

    private var postRepository: PostRepository = RealmPostRepositoryImpl()

    override fun findAllMyPosts(): RealmResults<Post> {
        return postRepository.findAllMyPosts()
    }

    override fun findPostById(id: Long): Post? {
        return postRepository.findOneById(id)
    }

    override fun createOrEditPost(post: Post): Boolean {

        val savedPost: Post? = null
        if (post.getId() == null) postRepository.save(post)
        else postRepository.update(post)

        return savedPost != null
    }

    override fun deletePostById(id: Long): Boolean {
        val deletingPost: Post? = findPostById(id)
        if (deletingPost != null) postRepository.delete(deletingPost)
        val deletedPost: Post? = findPostById(id)
        return deletedPost == null
    }
}