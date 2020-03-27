package com.app.telnet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ServerSocketFactory;

import com.app.utils.ApplicationConstants;
import com.app.utils.CommonUtils;

public class TelnetServer {
	
	private TelnetServer(){}

	public static void start() {
		CommonUtils.printLogs("Starting up Telnet Server...");
		CommonUtils.printLogs("-------------------------------");
		CommonUtils.printLogs("Available Telnet Commands:::");
		for (Object command : TelnetUtils.getTelnetCommands()) {
			CommonUtils.printLogs(command.toString());
		}
		final ExecutorService clientProcessingPool = Executors
				.newFixedThreadPool(ApplicationConstants.TELNET_THREADSIZE);
		Runnable serverTask = new Runnable() {

			@Override
			public void run() {
				try {
					ServerSocket serverSocket = ServerSocketFactory.getDefault()
							.createServerSocket(ApplicationConstants.TELNET_PORT);
					CommonUtils.printLogs("-------------------------------------------------");
					while (true) {
						Socket clientSocket = serverSocket.accept();
						clientProcessingPool.submit(new ClientTask(clientSocket));
					}
				} catch (Exception e) {
				}
			}
		};
		Thread serverThread = new Thread(serverTask);
		serverThread.start();
	}
}

class ClientTask implements Runnable {
	
	private static boolean secureTelnet = Boolean.valueOf(CommonUtils.getApplicationProperties("telnet.secure"));
	
	private static AbstractTelnetManager manager;
	
	static {
		if (secureTelnet) {
			manager = SecureTelnetIOManager.getInstance();
		} else {
			manager = TelnetIOManager.getInstance();
		}
	}
	
	private final Socket clientSocket;

	public ClientTask(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	@Override
	public void run() {
		CommonUtils.printLogs("Connection Coming From " + clientSocket.getRemoteSocketAddress());
		try {
			manager.setState(STATE.STATE_INITIALIZING);
			OutputStream clientStream = clientSocket.getOutputStream();
			PrintWriter out = new PrintWriter(clientStream, true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String inputLine, outputLine;
			outputLine = manager.processInput(null);
			out.println(outputLine);
			while ((inputLine = in.readLine()) != null) {
				outputLine = manager.processInput(inputLine);
				out.println(outputLine);
			}
			clientSocket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
