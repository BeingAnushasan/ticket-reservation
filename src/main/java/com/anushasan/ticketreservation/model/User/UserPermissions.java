package com.anushasan.ticketreservation.model.User;


import org.springframework.security.core.GrantedAuthority;


public enum UserPermissions implements GrantedAuthority {
    create_USER,
    update_USER,
    delete_USER,
    view_USER,
    reserve_TICKET,
    edit_TICKET,
    delete_TICKET;

    private String permissions;

    @Override
    public String getAuthority() {
        return permissions;
    }

    public String getPermissions() {
        return permissions;
    }

}
