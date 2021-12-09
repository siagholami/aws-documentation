# Organizing Files in Your Amazon S3 Bucket<a name="organize-s3"></a>

Amazon Elastic Transcoder integrates with Amazon S3 to store input and output files\. The 100\-bucket storage limit in Amazon S3 affects how you organize and manage your Elastic Transcoder files\.

When you work with Amazon S3, we recommend that you mimic a [regular file system](http://aws.amazon.com/articles/1109#08)\. You can do this by using the OutputKeyPrefix in Elastic Transcoder to add file paths to your output file\. Mimicking a file system allows you to use the [prefix and delimiter parameters](https://docs.aws.amazon.com/AmazonS3/latest/dev/ListingKeysHierarchy.html) in the Amazon S3 API to find your files\.

For example, suppose you are creating a user\-generated content \(UGC\) site that takes in videos for many customers and transcodes them for use on several common devices\. To store the videos, you could organize your input and output buckets like this:

```
Input:  /<your bucket>/users/<user account>/input/movie.mp4
Output:  /<your bucket>/users/<user account>/output/movie/<format>/movie.mp4
```

This enables you to store separate formats so you can locate them easily\. For example, say you have two customers using your service to transcode different movies into multiple formats\. You can organize your bucket like this:

```
Customer 1:
/<your bucket>/users/<user account 1>/output/movie/avi/movie.avi
/<your bucket>/users/<user account 1>/output/movie/mkv/movie.mkv
/<your bucket>/users/<user account 1>/output/movie/hls400k/movie.m3u8
  - playlist file for the hls400k version of movie
/<your bucket>/users/<user account 1>/output/movie/hls400k/movie.ts
  - video file for the hls400k version of movie
/<your bucket>/users/<user account 1>/output/movie/hls400k/movie.png 
  - thumbnail file for the hls400k version of movie
/<your bucket>/users/<user account 1>/output/myOthermovie/hls1000k/movie.m3u8
  - playlist file for the hls1000k version of movie
/<your bucket>/users/<user account 1>/output/myOthermovie/hls1000k/movie.ts
  - video file for the hls1000k version of movie
/<your bucket>/users/<user account 1>/output/myOthermovie/hls1000k/movie.png
  - thumbnail file for the hls1000k version of movie
```

```
Customer 2:
/<your bucket>/users/<user account 2>/output/somemovie/avi/somemovie.avi
/<your bucket>/users/<user account 2>/output/somemovie/mkv/somemovie.mkv
/<your bucket>/users/<user account 2>/output/somemovie/hls400k/somemovie.m3u8
  - playlist file for the hls400k version of somemovie
/<your bucket>/users/<user account 2>/output/somemovie/hls400k/somemovie.ts
  - video file for the hls400k version of somemovie
/<your bucket>/users/<user account 2>/output/somemovie/hls400k/somemovie.png
  - thumbnail file for the hls400k version of somemovie
/<your bucket>/users/<user account 2>/output/myOthermovie/hls1000k/movie.m3u8
  - playlist file for the hls1000k version of movie
/<your bucket>/users/<user account 2>/output/myOthermovie/hls1000k/movie.ts
  - video file for the hls1000k version of movie
/<your bucket>/users/<user account 2>/output/myOthermovie/hls1000k/movie.png
  - thumbnail file for the hls1000k version of movie
```

We recommend that you end your OutputKeyPrefix with a '/' so that the last part of the `OutputKeyPrefix` and the `OutputKey` don't run together\. Otherwise, your files will look like this:

```
/users/<user account>/output/<movie title>/mkvmovie.mkv
```

We also recommend that you keep your input media in a single bucket per region, and that you keep transcoded media and thumbnails in a separate bucket in the same region\. This approach helps you avoid cross\-region transfer fees between your Amazon S3 bucket and Elastic Transcoder\.

**Note**  
If you expect to have more than a hundred requests per second accessing your Amazon S3 buckets, we recommend you follow [Amazon S3 performance considerations](https://docs.aws.amazon.com/AmazonS3/latest/dev/request-rate-perf-considerations.html) when designing your system\.