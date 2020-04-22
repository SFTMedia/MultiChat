package xyz.olivermartin.multichat.proxy.common.config;

import java.io.File;

import xyz.olivermartin.multichat.proxy.bungee.config.ProxyBungeeChatControlConfig;
import xyz.olivermartin.multichat.proxy.bungee.config.ProxyBungeeJoinMessagesConfig;
import xyz.olivermartin.multichat.proxy.bungee.config.ProxyBungeeMainConfig;
import xyz.olivermartin.multichat.proxy.common.MultiChatProxyPlatform;

/**
 * MultiChatProxy's Config Manager
 * 
 * <p>Manages all access to configuration files etc.</p>
 * 
 * @author Oliver Martin (Revilo410)
 *
 */
public class ProxyConfigManager {

	private ProxyMainConfig proxyMainConfig;
	private ProxyJoinMessagesConfig proxyJoinMessagesConfig;
	private ProxyChatControlConfig proxyChatControlConfig;

	private MultiChatProxyPlatform platform;

	public ProxyConfigManager(MultiChatProxyPlatform platform) { 
		this.platform = platform;
	}

	public MultiChatProxyPlatform getPlatform() {
		return this.platform;
	}

	/**
	 * Register the main proxy config file with the Proxy Config Manager
	 * 
	 * <p>Should be registered in onEnable()</p>
	 * 
	 * @param platform The platform MultiChatProxy is using (i.e. Bungee)
	 * @param fileName filename i.e. config.yml
	 * @param configPath THE PATH WITHOUT THE FILE NAME
	 */
	public void registerProxyMainConfig(String fileName, File configPath) {

		switch (platform) {
		case BUNGEE:
			proxyMainConfig = new ProxyBungeeMainConfig(configPath, fileName);
			break;
		default:
			throw new IllegalArgumentException("Could not register config because this type of platform (" + platform.toString() + ") is not allowed.");

		}

	}

	/**
	 * Register the proxy join messages config file with the Proxy Config Manager
	 * 
	 * <p>Should be registered in onEnable()</p>
	 * 
	 * @param platform The platform MultiChatProxy is using (i.e. Bungee)
	 * @param fileName filename i.e. joinmessages.yml
	 * @param configPath THE PATH WITHOUT THE FILE NAME
	 */
	public void registerProxyJoinMessagesConfig(String fileName, File configPath) {

		switch (platform) {
		case BUNGEE:
			proxyJoinMessagesConfig = new ProxyBungeeJoinMessagesConfig(configPath, fileName);
			break;
		default:
			throw new IllegalArgumentException("Could not register config because this type of platform (" + platform.toString() + ") is not allowed.");

		}

	}

	/**
	 * Register the proxy chat control config file with the Proxy Config Manager
	 * 
	 * <p>Should be registered in onEnable()</p>
	 * 
	 * @param platform The platform MultiChatProxy is using (i.e. Bungee)
	 * @param fileName filename i.e. chatcontrol.yml
	 * @param configPath THE PATH WITHOUT THE FILE NAME
	 */
	public void registerProxyChatControlConfig(String fileName, File configPath) {

		switch (platform) {
		case BUNGEE:
			proxyChatControlConfig = new ProxyBungeeChatControlConfig(configPath, fileName);
			break;
		default:
			throw new IllegalArgumentException("Could not register config because this type of platform (" + platform.toString() + ") is not allowed.");

		}

	}

	public ProxyMainConfig getProxyMainConfig() {

		if (proxyMainConfig == null) throw new IllegalStateException("No proxy main config has been registered");
		return proxyMainConfig;

	}

	public ProxyJoinMessagesConfig getProxyJoinMessagesConfig() {

		if (proxyJoinMessagesConfig == null) throw new IllegalStateException("No proxy join messages config has been registered");
		return proxyJoinMessagesConfig;

	}

	public ProxyChatControlConfig getProxyChatControlConfig() {

		if (proxyChatControlConfig == null) throw new IllegalStateException("No proxy chat control config has been registered");
		return proxyChatControlConfig;

	}

}
