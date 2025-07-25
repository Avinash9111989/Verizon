package com.vas;
import java.util.*;
import java.util.stream.Collectors;

public class VASSubscriptionManager {

    private final Map<String, Set<String>> userVASMap = new HashMap<>();

    public void subscribe(User u, VAS vas) {
        if (u == null || vas == null) throw new IllegalArgumentException("User or VAS cannot be null");

        Set<String> currentVAS = userVASMap.computeIfAbsent(u.getUserId(), k -> new HashSet<>());
        if (currentVAS.contains(vas.getName()))
            throw new RuntimeException("Already subscribed to: " + vas.getName());

        if (u.getBalance() < vas.getCost()) throw new RuntimeException("Insufficient balance");

        u.setBalance(u.getBalance() - vas.getCost());
        u.getActiveVAS().add(vas);
        currentVAS.add(vas.getName());
    }

    public void unsubscribe(User u, String vasName) {
        u.getActiveVAS().removeIf(v -> v.getName().equalsIgnoreCase(vasName));
        Set<String> currentVAS = userVASMap.getOrDefault(u.getUserId(), new HashSet<>());
        currentVAS.remove(vasName);
    }

    public List<String> getSubscribedServices(User u) {
        return u.getActiveVAS().stream().map(VAS::getName).collect(Collectors.toList());
    }

    public boolean isUserSubscribedToAnyVAS(User u) {
        return userVASMap.getOrDefault(u.getUserId(), Collections.emptySet()).size() > 0;
    }

    public Map<String, Set<String>> getAllSubscriptions() {
        return Collections.unmodifiableMap(userVASMap);
    }
}
