package zookeeper;

import com.google.common.base.Charsets;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @Author : lijie
 * @Description :
 * @Date : Create in 2018/4/14 15:02
 * @Modified by :
 */
public class ZKTest {
    public static void main(String[] args) throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client =
                CuratorFrameworkFactory.newClient(
                        "47.94.87.93:2181",
                        5000,
                        3000,
                        retryPolicy);

        client.start();

        String key="/paascloud/registry/id/paascloud-provider-uac/188.188.1.155";
        String value="4";
        client.inTransaction().setData().forPath(key, value.getBytes(Charsets.UTF_8)).and().commit();
        System.out.println("操作成功");
    }
}
