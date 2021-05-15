package com.anushasan.ticketreservation.model.User;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.anushasan.ticketreservation.model.User.UserPermissions.*;


public enum UserRoles {
    role_ADMIN(Sets.newHashSet(create_USER, update_USER, delete_USER, view_USER, reserve_TICKET, delete_TICKET, edit_TICKET)),
    role_USER(Sets.newHashSet(update_USER, delete_USER, reserve_TICKET));

    private final Set<UserPermissions> permissions;

    UserRoles(Set<UserPermissions> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermissions> getPermissions() {
        return permissions;
    }
}
