package com.android.mytestapplication.service.impl

import com.android.mytestapplication.model.InternetPost
import com.android.mytestapplication.repository.impl.RealmInternetPostRepositoryImpl
import com.android.mytestapplication.service.interfaces.InternetPostService
import io.realm.RealmResults
import org.json.JSONArray

class InternetPostServiceImpl: InternetPostService {

    var internetPostRepository = RealmInternetPostRepositoryImpl()

    override fun downloadInternetPostsFromServer(internetPosts: JSONArray): Boolean {
        return internetPostRepository.saveAllFromServer(internetPosts)
    }

    override fun findAllInternetPosts(): RealmResults<InternetPost> {
        return internetPostRepository.findAllInternetPosts()
    }

//       var connection: URLConnection
//       var reader: BufferedReader
//       var url: URL = URL(URL)
//       var obj: JSONArray = JSONArray()
//
//       try {
//           var newThred = Thread(Runnable { kotlin.run {
//           connection = url.openConnection()
//           val inputStream = connection.getInputStream()
//               val inputStreamReader = InputStreamReader(inputStream)
//           reader = BufferedReader(inputStreamReader)
//           val stringBuffer: StringBuffer = StringBuffer()
//           var line: String? = null
//           line = reader.readLine()
//           while(line != null){
//               stringBuffer.append(line)
//               line = reader.readLine()
//           }
//           obj = JSONArray(stringBuffer.toString())
//               postRepository.saveAllFromServer(obj)
//       } })
//           newThred.start()
//
//       }catch (ex: Exception){
//           return JSONArray()
//       }
//       return JSONArray()
//   }
//
//   }
}